<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
   String studentName = (String) session.getAttribute("studentName");
   if (studentName == null) {
       response.sendRedirect("login.jsp");
       return;
   }
   %>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <script src="https://cdn.tailwindcss.com"></script>
      <link rel="stylesheet" href="./css/styles.css" />
      <link rel="stylesheet" href="./css/dashboard.css" />
      <title>Dashboard | CampusCare</title>
   </head>
   <body class="bg-black h-screen flex items-center justify-center animate-fadeIn bg-gradient-to-br from-gray-900 via-black to-gray-800">
      <div>
         <div class="w-full max-w-2xl bg-gray-900/50 backdrop-blur-lg p-10 rounded-2xl border border-gray-800 shadow-lg relative">
            <!-- Decorative Corners -->
            <div class="absolute top-0 left-0 w-20 h-20 border-t-2 border-l-2 border-pink-500 rounded-tl-2xl"></div>
            <div class="absolute top-0 right-0 w-20 h-20 border-t-2 border-r-2 border-red-400 rounded-tr-2xl"></div>
            <div class="absolute bottom-0 left-0 w-20 h-20 border-b-2 border-l-2 border-yellow-500 rounded-bl-2xl"></div>
            <div class="absolute bottom-0 right-0 w-20 h-20 border-b-2 border-r-2 border-pink-500 rounded-br-2xl"></div>
            <h2 class="text-4xl font-bold text-white mb-6 text-center">
               Welcome, <span class="text-pink-400"><%= studentName %></span>
            </h2>
            <p class="text-gray-400 mb-8 text-center text-lg">
               You have successfully logged into your CampusCare dashboard.
            </p>
            <!-- Logout Button -->
            <div class="text-center">
               <form action="LogoutServlet" method="get">
                  <button type="submit"
                     class="inline-block px-6 py-3 bg-gradient-to-r from-red-500 via-pink-500 to-yellow-500 text-white font-semibold rounded-lg
                     hover:opacity-90 transition duration-300 ease-in-out transform hover:scale-105 hover:shadow-lg">
                  Logout
                  </button>
               </form>
            </div>
         </div>
         <!-- Footer -->
         <footer class="mt-10 text-center text-gray-600 text-sm">
            &copy; 2025 CampusCare. All rights reserved.
         </footer>
      </div>
   </body>
</html>
