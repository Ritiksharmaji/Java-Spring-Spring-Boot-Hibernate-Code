// Form validation script
document.addEventListener("DOMContentLoaded", () => {
    const form = document.querySelector("form");
    form.addEventListener("submit", (e) => {
        const emailField = form.querySelector("input[name='email']");
        const passwordField = form.querySelector("input[name='password']");
        const mobileField = form.querySelector("input[name='mobile']");

        // Email validation
        const emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
        if (!emailField.value.match(emailPattern)) {
            alert("Please enter a valid email address.");
            e.preventDefault();
            return;
        }

        // Password validation
        if (passwordField.value.length < 8) {
            alert("Password must be at least 8 characters long.");
            e.preventDefault();
            return;
        }

        // Mobile number validation
        const mobilePattern = /^[0-9]{10}$/;
        if (!mobileField.value.match(mobilePattern)) {
            alert("Please enter a valid 10-digit mobile number.");
            e.preventDefault();
            return;
        }
    });
});
