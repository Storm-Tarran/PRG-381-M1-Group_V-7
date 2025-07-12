<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <script src="https://cdn.tailwindcss.com"></script>
      <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600;700&display=swap" rel="stylesheet">
      <link rel="stylesheet" href="./css/styles.css" />
      <link rel="stylesheet" href="./css/index.css" />
      <title>CampusCare</title>
   </head>
   <body class="bg-black h-screen flex items-center justify-center animate-fadeIn bg-gradient-to-br from-gray-900 via-black to-gray-800">
      <div class="max-w-4xl w-full px-6">
         <div class="relative bg-gray-900/50 backdrop-blur-xl rounded-2xl p-8 border border-gray-800">
            <!-- Decorative Corners -->
            <div class="absolute top-0 left-0 w-20 h-20 border-t-2 border-l-2 border-pink-500 rounded-tl-2xl"></div>
            <div class="absolute top-0 right-0 w-20 h-20 border-t-2 border-r-2 border-red-400 rounded-tr-2xl"></div>
            <div class="absolute bottom-0 left-0 w-20 h-20 border-b-2 border-l-2 border-yellow-500 rounded-bl-2xl"></div>
            <div class="absolute bottom-0 right-0 w-20 h-20 border-b-2 border-r-2 border-pink-500 rounded-br-2xl"></div>
            <div class="relative">
               <!-- Logo -->
               <div class="flex justify-center mb-6">
                  <div class="text-5xl text-pink-500">🧠</div>
               </div>
               <h2 class="text-3xl font-bold mb-2 text-white text-center">CampusCare</h2>
               <h3 class="text-2xl font-semibold mb-6 text-center text-transparent bg-clip-text bg-gradient-to-t from-pink-500 via-red-400 to-yellow-500">
                  Register or log in to access support services
               </h3>
               <p class="text-lg text-gray-300 mb-8 text-center">
                  Providing students with wellness services designed to support their academic and personal growth.
               </p>
               <!-- Buttons -->
               <div class="flex flex-col md:flex-row justify-center gap-6">
                  <a href="register.jsp" aria-label="Register for a new student wellness account"
                     class="group inline-flex items-center justify-center gap-2 px-6 py-3 rounded-full border border-gray-700 hover:border-pink-500 hover:bg-pink-500/10 transition-all duration-300 ease-in-out transform hover:scale-105 text-white">
                  Register
                  </a>
                  <a href="login.jsp" aria-label="Login to your student wellness account"
                     class="group inline-flex items-center justify-center gap-2 px-6 py-3 rounded-full border border-gray-700 hover:border-yellow-500 hover:bg-yellow-500/10 transition-all duration-300 ease-in-out transform hover:scale-105 text-white">
                  Login
                  </a>
               </div>
            </div>
         </div>
         <!-- Footer -->
         <footer class="mt-10 text-center text-gray-600 text-sm">
            &copy; 2025 CampusCare. All rights reserved.
         </footer>
      </div>
   </body>
</html>
