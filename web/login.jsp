<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <script src="https://cdn.tailwindcss.com"></script>
      <script src="https://unpkg.com/validator@latest/validator.min.js"></script>
      <link rel="stylesheet" href="./css/styles.css" />
      <link rel="stylesheet" href="./css/login.css" />
      <script defer src="./js/loginValidation.js"></script>
      <script defer src="./js/viewPassword.js"></script>
      <title>Login | CampusCare</title>
   </head>
   <body class="pl-8 pr-8 bg-black h-screen flex items-center justify-center animate-fadeIn bg-gradient-to-br from-gray-900 via-black to-gray-800">
      <div>
         <div class="w-full max-w-md bg-gray-900/50 backdrop-blur-lg p-8 rounded-2xl border border-gray-800 shadow-lg relative">
            <div class="absolute top-0 left-0 w-20 h-20 border-t-2 border-l-2 border-pink-500 rounded-tl-2xl"></div>
            <div class="absolute top-0 right-0 w-20 h-20 border-t-2 border-r-2 border-red-400 rounded-tr-2xl"></div>
            <div class="absolute bottom-0 left-0 w-20 h-20 border-b-2 border-l-2 border-yellow-500 rounded-bl-2xl"></div>
            <div class="absolute bottom-0 right-0 w-20 h-20 border-b-2 border-r-2 border-pink-500 rounded-br-2xl"></div>

            <h2 class="text-3xl font-bold text-white mb-6 text-center">Login</h2>
            <p class="text-gray-400 mb-8 text-center">
               Login to access wellness services.
            </p>

            <div id="feedback" style="color: red" class="mb-4 text-sm text-center italic">
              <%
                 String loginError = (String) session.getAttribute("loginFeedback");
                 String logoutMsg = request.getParameter("msg");
                 String regSuccess = request.getParameter("reg");

                 if (loginError != null) {
              %>
                 <p class="text-red-400"><%= loginError %></p>
              <%
                    session.removeAttribute("loginFeedback");
                 } else if (logoutMsg != null) {
              %>
                 <p class="text-green-400"><%= logoutMsg %></p>
              <%
                 } else if ("success".equals(regSuccess)) {
              %>
                 <p class="text-green-400">Registration successful. Please log in.</p>
              <% } %>
            </div>

            <form id="loginForm" action="${pageContext.request.contextPath}/LoginServlet" method="post" class="space-y-6">
               <input type="text" placeholder="Email (e.g., user@example.com)" name="email"
                  class="w-full p-3 rounded-lg bg-gray-800 text-white border border-gray-700 focus:outline-none focus:border-pink-500"/>

               <div class="relative w-full">
                  <input type="password" placeholder="Password" name="password" id="password"
                     class="w-full p-3 rounded-lg bg-gray-800 text-white border border-gray-700 focus:outline-none focus:border-pink-500 pr-16"/>
                  <button type="button" onclick="togglePassword('password')"
                     class="absolute right-3 top-1/2 -translate-y-1/2 text-sm text-pink-400 hover:underline">
                     Show
                  </button>
               </div>

               <button type="submit"
                  class="w-full py-3 bg-gradient-to-r from-pink-500 via-red-400 to-yellow-500 text-white font-semibold rounded-lg
                  hover:opacity-90 transition duration-300 ease-in-out transform hover:scale-105 hover:shadow-lg">
                  Login
               </button>
            </form>

            <p class="mt-6 text-gray-400 text-sm text-center">
               Don't have an account?
               <a href="register.jsp" class="text-pink-400 hover:underline">Register here</a>
            </p>
         </div>

         <footer class="mt-10 text-center text-gray-600 text-sm">
            &copy; 2025 CampusCare. All rights reserved.
         </footer>
      </div>
   </body>
</html>
