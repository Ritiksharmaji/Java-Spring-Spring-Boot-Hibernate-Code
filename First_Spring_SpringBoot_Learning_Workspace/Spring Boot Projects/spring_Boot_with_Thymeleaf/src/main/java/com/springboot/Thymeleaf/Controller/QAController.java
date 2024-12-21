package com.springboot.Thymeleaf.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import java.io.File;

@Controller
public class QAController {

    @Autowired
    private QAService qaService;

    @GetMapping("/qa")
    public String displayQA(Model model) {
        List<QA> qaList = qaService.readQAPairsFromFile(
                "E:\\CODE\\spring and springBoot project\\Spring Boot Projects\\spring_Boot_with_Thymeleaf\\src\\main\\resources\\qa\\file.txt");
        model.addAttribute("qaList", qaList);

        // Add this debug code in your controller method
        File file = new File("path/to/qa/file.txt");
        System.out.println("File exists: " + file.exists());
        return "qa"; // Thymeleaf template name
    }
}
