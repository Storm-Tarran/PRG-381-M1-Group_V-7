package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.ResultSet;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author USER
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final Logger logger = Logger.getLogger(RegisterServlet.class.getName());


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String dbURL = "jdbc:postgresql://localhost:5432/StudentWellness";
            String dbUSER = "Admin4";
            String dbPASSWORD = "Admin4";
        
            String studentNumber = request.getParameter("student_number");
            String studentName = request.getParameter("name");
            String studentSurname = request.getParameter("lastname");
            String studentEmail = request.getParameter("email");
            String studentPhone = request.getParameter("phone");
            String studentPassword = request.getParameter("password");
            
            studentPassword = BCrypt.hashpw(studentPassword, BCrypt.gensalt());
            
        try {
            //Driver class from connection of database
            Class.forName("org.postgresql.Driver");
            try (Connection  conn = DriverManager.getConnection(dbURL, dbUSER, dbPASSWORD);
                 PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO login.login_credentials(studentnumber, studentname, studentsurname, studentemail, studentphone, studentpassword) VALUES(?,?,?,?,?,?)");
                 PreparedStatement dup = conn.prepareStatement("SELECT 1 FROM login.login_credentials WHERE studentnumber = ?");
            ) {
                /* duplicate check */
                dup.setString(1, studentNumber);
                try (ResultSet rs = dup.executeQuery()) {
                    if (rs.next()) {
                        // number already exists
                        response.sendRedirect(request.getContextPath() + "/login.jsp?error=duplicate");
                        return;
                    }
                }

                ps.setString(1, studentNumber);
                ps.setString(2, studentName);
                ps.setString(3, studentSurname);
                ps.setString(4, studentEmail);
                ps.setString(5, studentPhone);
                ps.setString(6, studentPassword);

                ps.executeUpdate();
                request.getSession().setAttribute("studentName", studentName);
                response.sendRedirect(request.getContextPath() + "/dashboard.jsp");   // success
            }
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "PostgreSQL driver not found, can't connect", ex);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }catch(SQLException ex){
            logger.log(Level.SEVERE, "Database connection error", ex);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        
    }


}
