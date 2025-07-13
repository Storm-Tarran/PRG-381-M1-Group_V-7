/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author USER
 */
public class DBConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/StudentWellness";
    private static final String USER = "Admin4";
    private static final String PASSWORD = "Admin4";
    
    //Static: Runs once when the class is loaded.
    static{
        try{
            //Load JDBC driver
            Class.forName("org.postgresql.Driver");
            System.out.println("Connected to PostgreSQL server");
        }catch(ClassNotFoundException e){
            System.out.println("Could not connect to PostgreSQL server");
            throw new ExceptionInInitializerError(e);
        }
    }
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

}
