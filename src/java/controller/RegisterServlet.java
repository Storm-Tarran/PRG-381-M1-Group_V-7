package controller;

import dao.DaoUser;
import model.User;
import org.mindrot.jbcrypt.BCrypt;
import util.DBConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private static final Logger logger = Logger.getLogger(RegisterServlet.class.getName());
    private final DaoUser daoUser = new DaoUser(); // Data access object for user operations

    @Override
    public void init() throws ServletException {
        try {
            // Load database configuration from properties file
            DBConnection.loadProperties(getServletContext());
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to load DB properties during servlet init", e);
            throw new ServletException("Database configuration error", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve user-submitted registration fields from request
        String studentNumber = request.getParameter("student_number");
        String name = request.getParameter("name");
        String surname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String plainPassword = request.getParameter("password");

        // Validate that all required fields are present
        if (studentNumber == null || name == null || surname == null || email == null || phone == null || plainPassword == null) {
            // Redirect back to registration with error message
            response.sendRedirect("register.jsp?msg=Missing+required+fields");
            return;
        }

        try {
            // Hash the password for security
            String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());

            // Create a User object with the submitted information
            User user = new User(studentNumber, name, surname, email, phone, hashedPassword);

            // Check if a user already exists with the same student number or email
            if (daoUser.isUserExists(studentNumber, email)) {
                // Redirect back to registration with duplicate account error
                response.sendRedirect("register.jsp?msg=Account+already+exists");
                return;
            }

            // Attempt to register the new user in the database
            if (daoUser.registerUser(user)) {
                // Registration successful: redirect to login page with success flag
                response.sendRedirect("login.jsp?reg=success");
            } else {
                // Registration failed due to unknown reasons
                response.sendRedirect("register.jsp?msg=Registration+failed");
            }

        } catch (SQLException e) {
            // Database error during registration
            response.sendRedirect("register.jsp?msg=Database+error");
        }
    }
}
