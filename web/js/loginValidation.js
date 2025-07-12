document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("loginForm");
  const feedback = document.getElementById("feedback");

  form.addEventListener("submit", function (e) {
    e.preventDefault();

    const email = form.email.value.trim();

    // Email validation using validator.js
    if (!validator.isEmail(email)) {
      feedback.textContent = "Please enter a valid email address.";
      return;
    }

    feedback.textContent = ""; // Clear any previous errors

    // Submit the form
    form.submit();
  });
});
