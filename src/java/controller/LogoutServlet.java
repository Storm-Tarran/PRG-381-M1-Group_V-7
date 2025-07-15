package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the existing session if one exists, without creating a new one
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();  // Terminate the current user session
        }

        // Redirect the user to the login page with a logout success message
        response.sendRedirect(request.getContextPath() + "/login.jsp?msg=You+have+been+logged+out+successfully");
    }
}
