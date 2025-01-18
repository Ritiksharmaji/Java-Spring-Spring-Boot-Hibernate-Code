package com.simple.registration.controller;

import com.simple.registration.entities.Registration;
import com.simple.registration.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController1 {

    @Autowired
    private RegistrationService registrationService;

    // Show the registration form
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registration", new Registration());
        return "registration-form";  // Thymeleaf template for the registration form
    }

    // Handle form submission
    @PostMapping("/register")
    public String submitRegistrationForm(Registration registration) {
        registrationService.saveRegistration(registration);
        return "registration-success";  // Confirmation page after successful registration
    }
}
