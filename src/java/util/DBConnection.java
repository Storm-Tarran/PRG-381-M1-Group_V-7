package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;
import jakarta.servlet.ServletContext;
import java.util.logging.Logger;
import java.util.logging.Level;

public class DBConnection {

    private static final Logger logger = Logger.getLogger(DBConnection.class.getName());

    private static String URL;
    private static String USER;
    private static String PASSWORD;

    // Load PostgreSQL JDBC driver when class is first loaded
    static {
        try {
            Class.forName("org.postgresql.Driver");
            logger.info("PostgreSQL JDBC Driver registered successfully.");
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "PostgreSQL JDBC Driver not found. Application cannot proceed.", e);
            throw new ExceptionInInitializerError(e);
        }
    }


     //Loads database configuration (URL, username, password).
    public static void loadProperties(ServletContext context) throws IOException {
        try (InputStream input = context.getResourceAsStream("/WEB-INF/db.properties")) {
            if (input == null) {
                String msg = "Database configuration file 'db.properties' not found in /WEB-INF.";
                logger.severe(msg);
                throw new IOException(msg);
            }

            Properties props = new Properties();
            props.load(input);  // Load properties from the file

            // Retrieve DB connection details
            URL = props.getProperty("db.url");
            USER = props.getProperty("db.user");
            PASSWORD = props.getProperty("db.password");

            // Validate that all required properties are present
            if (URL == null || USER == null || PASSWORD == null) {
                String msg = "Database credentials (url, user, password) must be set in db.properties.";
                logger.severe(msg);
                throw new IOException(msg);
            }

            logger.info("Database properties loaded successfully.");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to load database properties.", e);
            throw e;  // rethrow to notify caller
        }
    }


     // Returns a database connection using loaded properties.
    public static Connection getConnection() throws SQLException {
        // Check that DB properties are loaded before trying to connect
        if (URL == null || USER == null || PASSWORD == null) {
            String msg = "Database credentials are not loaded. Call loadProperties() before getConnection().";
            logger.severe(msg);
            throw new SQLException(msg);
        }

        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);  // Establish connection
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Failed to establish database connection.", e);
            throw e;
        }
    }
}
