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
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author USER
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    
    //Connection
    Connection conn;
    PreparedStatement ps;
    PreparedStatement ps1;
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Register
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        Class.forName("org.postgresql.Driver");
        
        
        
        
        
       
    }


}
