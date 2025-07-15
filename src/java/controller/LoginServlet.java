package controller;

import dao.DaoUser;
import model.User;
import util.DBConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(LoginServlet.class.getName());
    private final DaoUser daoUser = new DaoUser(); // DAO for interacting with the user table

    @Override
    public void init() throws ServletException {
        try {
            // Load DB config properties once when the servlet initializes
            DBConnection.loadProperties(getServletContext());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to load DB properties", e);
            throw new ServletException("Database configuration error", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get login credentials from the request
        String email = request.getParameter("email");
        String plainPassword = request.getParameter("password");

        // Basic input validation
        if (email == null || plainPassword == null || email.isEmpty() || plainPassword.isEmpty()) {
            logger.warning("Missing login credentials");
            redirectWithError(request, response, "Email and password are required.");
            return;
        }

        try {
            // Attempt to log in the user using email and password
            User user = daoUser.loginUser(email.trim(), plainPassword);

            if (user != null) {
                // Create a session and store user info
                HttpSession session = request.getSession(true);
                session.setAttribute("studentName", user.getName());
                session.setAttribute("studentEmail", user.getEmail());

                // Redirect to dashboard after successful login
                response.sendRedirect("dashboard.jsp");
            } else {
                // Invalid login attempt
                redirectWithError(request, response, "Invalid email or password.");
            }

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Login failed", e);
            // Redirect with generic DB error message
            response.sendRedirect("login.jsp?msg=Database+error");
        }
    }

    // Helper method to store error message in session and redirect to login page
    private void redirectWithError(HttpServletRequest request, HttpServletResponse response, String msg)
            throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("loginFeedback", msg);
        response.sendRedirect("login.jsp");
    }
}
