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

    // Logger to record events for debugging or auditing
    private static final Logger logger = Logger.getLogger(LoginServlet.class.getName());

    // DAO class to interact with the database for user login (not handling login count here)
    private final DaoUser daoUser = new DaoUser();

    @Override
    public void init() throws ServletException {
        try {
            // Load database configuration once when the servlet starts
            DBConnection.loadProperties(getServletContext());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to load DB properties", e);
            throw new ServletException("Database configuration error", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get login credentials from form
        String email = request.getParameter("email");
        String plainPassword = request.getParameter("password");

        // Check for empty email or password fields
        if (email == null || plainPassword == null || email.isEmpty() || plainPassword.isEmpty()) {
            redirectWithError(request, response, "Email and password are required.");
            return;
        }

        // Get or create a session for the current user
        HttpSession session = request.getSession(true);

        // Get the current login attempt count from the session
        Integer loginCount = (Integer) session.getAttribute("loginCount");

        // If it's the user's first login attempt, initialize count to 0
        if (loginCount == null) {
            loginCount = 0;
        }

        // If user has already failed 4 or more times, block login
        if (loginCount >= 4) {
            redirectWithError(request, response, "Too many login attempts. Try again later.");
            return;
        }

        try {
            // Try to authenticate the user using provided credentials
            User user = daoUser.loginUser(email.trim(), plainPassword);

            if (user != null) {
                // If login is successful, store user info in session
                session.setAttribute("studentName", user.getName());
                session.setAttribute("studentEmail", user.getEmail());

                // Reset the login attempt counter on successful login
                session.removeAttribute("loginCount");

                // Redirect to the dashboard page
                response.sendRedirect("dashboard.jsp");
            } else {
                // Failed login: increment the login counter
                loginCount++;
                session.setAttribute("loginCount", loginCount);

                // Notify user of failed login
                redirectWithError(request, response, "Invalid email or password.");
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Login error", e);
            response.sendRedirect("login.jsp?msg=Database+error");
        }
    }

    // Helper method to display an error message and redirect to login page
    private void redirectWithError(HttpServletRequest request, HttpServletResponse response, String msg)
            throws IOException {
        request.getSession().setAttribute("loginFeedback", msg);
        response.sendRedirect("login.jsp");
    }
}
