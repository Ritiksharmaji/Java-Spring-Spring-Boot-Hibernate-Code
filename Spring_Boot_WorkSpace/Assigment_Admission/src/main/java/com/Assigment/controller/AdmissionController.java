package com.Assigment.controller;

import com.Assigment.entity.Admission;
import com.Assigment.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    @GetMapping("/admission-form")
    public String showAdmissionForm(Model model) {
        model.addAttribute("admission", new Admission());
        return "admission-form"; // Corresponds to Thymeleaf template
    }

    @PostMapping("/submit-admission")
    public String submitAdmission(Admission admission) {
    	System.out.print("controller execute");
        admissionService.saveAdmission(admission);
        System.out.print("admissionService execute");
        return "redirect:/admissions"; // Redirect to the admissions list
    }

    @GetMapping("/admissions")
    public String listAdmissions(Model model) {
        model.addAttribute("admissions", admissionService.getAllAdmissions());
        return "admissions"; // Corresponds to Thymeleaf template
    }
}
