package dao;

import model.User;
import util.DBConnection;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;

public class DaoUser {


     // Checks if a user with the given student number or email exists.
    public boolean isUserExists(String studentNumber, String email) throws SQLException {
        String query = "SELECT 1 FROM login.login_credentials WHERE studentnumber = ? OR studentemail = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, studentNumber);
            ps.setString(2, email);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // true if any record is found
            }
        }
    }


    // Registers a new user in the database with hashed password.
    public boolean registerUser(User user) throws SQLException {
        String query = "INSERT INTO login.login_credentials(studentnumber, studentname, studentsurname, studentemail, studentphone, studentpassword) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            // Set values from the User object to the prepared statement
            ps.setString(1, user.getStudentNumber());
            ps.setString(2, user.getName());
            ps.setString(3, user.getSurname());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getPassword()); // already hashed

            return ps.executeUpdate() > 0; // true if insert was successful
        }
    }

    /**
     * Attempts to log in a user by email and password.
     * If successful, returns a populated User object otherwise, null.
     */
    public User loginUser(String email, String plainPassword) throws SQLException {
        String query = "SELECT studentnumber, studentname, studentsurname, studentphone, studentpassword FROM login.login_credentials WHERE studentemail = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String hashedPassword = rs.getString("studentpassword");

                    // Compare hashed password with entered plain password
                    if (BCrypt.checkpw(plainPassword, hashedPassword)) {
                        // If passwords create and return User object
                        User user = new User();
                        user.setStudentNumber(rs.getString("studentnumber"));
                        user.setName(rs.getString("studentname"));
                        user.setSurname(rs.getString("studentsurname"));
                        user.setPhone(rs.getString("studentphone"));
                        user.setEmail(email);
                        return user;
                    }
                }
            }
        }

        // Email not found or password mismatch
        return null;
    }
}
