const form = document.getElementById("registerForm");
const feedback = document.getElementById("feedback");

form.addEventListener("submit", function (e) {
  e.preventDefault();

  const studentNumber = form.student_number.value.trim();
  const firstName = form.name.value.trim();
  const lastName = form.lastname.value.trim();
  let phone = form.phone.value.trim();
  const email = form.email.value.trim();
  const password = form.password.value;
  const confirmPassword = form.confirm_password.value;

  // Student number must be an integer
  if (!validator.isInt(studentNumber)) {
    feedback.textContent = "Student number must be a valid integer.";
    return;
  }

  // Name validation
  if (!validator.isAlpha(firstName, "en-US", { ignore: " " })) {
    feedback.textContent = "First name must contain letters only.";
    return;
  }

  if (!validator.isAlpha(lastName, "en-US", { ignore: " " })) {
    feedback.textContent = "Last name must contain letters only.";
    return;
  }

  // Email validation
  if (!validator.isEmail(email)) {
    feedback.textContent = "Please enter a valid email address.";
    return;
  }

  // Format South African phone numbers
  if (phone.startsWith("0")) {
    phone = "+27" + phone.slice(1); // 0821234567 -> +27821234567
  } else if (phone.startsWith("27") && phone.length === 11) {
    phone = "+" + phone; // 27821234567 -> +27821234567
  }

  // Assign back to form field
  form.phone.value = phone;

  // Phone validation
  if (!validator.isMobilePhone(phone, "en-ZA", { strictMode: true })) {
    feedback.textContent =
      "Phone number must be valid and start with +27 followed by 9 digits (e.g., +27821234567).";
    return;
  }

  // Password validation
  if (
    !validator.isStrongPassword(password, {
      minLength: 8,
      minLowercase: 1,
      minUppercase: 1,
      minNumbers: 1,
      minSymbols: 1,
    })
  ) {
    feedback.textContent =
      "Password must be at least 8 characters and include an uppercase letter, lowercase letter, number, and symbol.";
    return;
  }

  // Password match check
  if (password !== confirmPassword) {
    feedback.textContent = "Passwords do not match.";
    return;
  }

  feedback.textContent = ""; // Clear any existing errors

  // Submit the form manually
  form.submit();
});
