function togglePassword(id) {
  const input = document.getElementById(id);
  const button = input.nextElementSibling;
  if (input.type === "password") {
    input.type = "text";
    button.textContent = "Hide";
  } else {
    input.type = "password";
    button.textContent = "Show";
  }
}
