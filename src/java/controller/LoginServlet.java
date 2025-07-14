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
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;
import java.sql.SQLException;
//import java.util.HashSet;
//import java.util.Set;


/**
 *
 * @author USER
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    
    private static final Logger logger =
            Logger.getLogger(LoginServlet.class.getName());

    private static final String dbURL ="jdbc:postgresql://localhost:5432/StudentWellness";
    private static final String dbUSER = "Admin4";
    private static final String dbPASSWORD = "Admin4";

    /* load driver once */
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String email = request.getParameter("email");
            String passwd = request.getParameter("password");
            
            String errMessage = "Invalid email or password. Try again";

        try (Connection conn = DriverManager.getConnection(dbURL, dbUSER, dbPASSWORD);
             PreparedStatement ps = conn.prepareStatement("SELECT studentname, studentpassword FROM login.login_credentials WHERE studentemail = ?")) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String hash = rs.getString("studentpassword");
                    String name = rs.getString("studentname");

                    if (BCrypt.checkpw(passwd, hash)) {
                        /* success → store name in session */
                        HttpSession session = request.getSession(true);
                        session.setAttribute("studentName", name);
                        response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
                        return; 
                    }else{
                        errMessage = "Invalid email or password";
                    }
                }else{
                    errMessage = "Invalid email or password";
                }
            }
            //New http session for login issues
            HttpSession session = request.getSession();
            session.setAttribute("loginError", errMessage);
            response.sendRedirect("login.jsp");

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "DB error", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }   
 

}
