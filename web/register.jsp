<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
      <script src="https://cdn.tailwindcss.com"></script>
      <script src="https://unpkg.com/validator@latest/validator.min.js"></script>
      <link rel="stylesheet" href="./css/styles.css" />
      <link rel="stylesheet" href="./css/register.css" />
      <script defer src="./js/registerValidation.js"></script>
      <script defer src="./js/viewPassword.js"></script>
      <title>Register | CampusCare</title>
   </head>
   <body class="pl-8 pr-8 pt-20 pb-20 bg-black flex items-center justify-center animate-fadeIn bg-gradient-to-br from-gray-900 via-black to-gray-800">
      <div>
         <div class="w-full max-w-xl bg-gray-900/50 backdrop-blur-lg p-8 rounded-2xl border border-gray-800 shadow-lg relative">
            <!-- Decorative Corners -->
            <div class="absolute top-0 left-0 w-20 h-20 border-t-2 border-l-2 border-pink-500 rounded-tl-2xl"></div>
            <div class="absolute top-0 right-0 w-20 h-20 border-t-2 border-r-2 border-red-400 rounded-tr-2xl"></div>
            <div class="absolute bottom-0 left-0 w-20 h-20 border-b-2 border-l-2 border-yellow-500 rounded-bl-2xl"></div>
            <div class="absolute bottom-0 right-0 w-20 h-20 border-b-2 border-r-2 border-pink-500 rounded-br-2xl"></div>
            <h2 class="text-3xl font-bold text-white mb-6 text-center">Create Your Account</h2>
            <p class="text-gray-400 mb-8 text-center">
               Register to access wellness services.
            </p>
            <!-- Feedback -->
            <div id="feedback" class="mb-4 text-sm text-center text-red-400 italic"></div>
            <form action="RegisterServlet" id="registerForm" class="space-y-6">
               <input type="text" placeholder="Student Number (digits only)" name="student_number"
                  class="w-full p-3 rounded-lg bg-gray-800 text-white border border-gray-700 focus:outline-none focus:border-pink-500" required />
               <input type="text" placeholder="First Name (letters only)" name="name"
                  class="w-full p-3 rounded-lg bg-gray-800 text-white border border-gray-700 focus:outline-none focus:border-pink-500" required />
               <input type="text" placeholder="Last Name (letters only)" name="lastname"
                  class="w-full p-3 rounded-lg bg-gray-800 text-white border border-gray-700 focus:outline-none focus:border-pink-500" required />
               <input type="text" placeholder="Email (e.g. name@example.com)" name="email"
                  class="w-full p-3 rounded-lg bg-gray-800 text-white border border-gray-700 focus:outline-none focus:border-pink-500" required />
               <input type="tel" placeholder="Phone Number (e.g. 0821234567 or +27821234567)" name="phone"
                  class="w-full p-3 rounded-lg bg-gray-800 text-white border border-gray-700 focus:outline-none focus:border-pink-500" required />
               <div class="relative">
                  <input type="password" placeholder="Password (min 8 chars, incl. uppercase, lowercase, number, symbol)" name="password"
                     id="password"
                     class="w-full p-3 rounded-lg bg-gray-800 text-white border border-gray-700 focus:outline-none focus:border-pink-500" required />
                  <button type="button" onclick="togglePassword('password')" class="absolute right-3 top-3 text-sm text-pink-400 hover:underline">Show</button>
               </div>
               <div class="relative">
                  <input type="password" placeholder="Confirm Password" name="confirm_password"
                     id="confirm_password"
                     class="w-full p-3 rounded-lg bg-gray-800 text-white border border-gray-700 focus:outline-none focus:border-pink-500" required />
                  <button type="button" onclick="togglePassword('confirm_password')" class="absolute right-3 top-3 text-sm text-pink-400 hover:underline">Show</button>
               </div>
               <button type="submit"
                  class="w-full py-3 bg-gradient-to-r from-pink-500 via-red-400 to-yellow-500 text-white font-semibold rounded-lg
                  hover:opacity-90 transition duration-300 ease-in-out transform hover:scale-105 hover:shadow-lg">
               Register
               </button>
            </form>
            <p class="mt-6 text-gray-400 text-sm text-center">
               Already have an account?
               <a href="login.jsp" class="text-pink-400 hover:underline">Login here</a>
            </p>
         </div>
         <!-- Footer -->
         <footer class="mt-10 text-center text-gray-600 text-sm">
            &copy; 2025 CampusCare. All rights reserved.
         </footer>
      </div>
   </body>
</html>
