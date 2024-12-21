package com.springbootlearning.learning;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class Controller {

    @Autowired
    private QAService qaService;

    @GetMapping("/qa")
    public String displayQA(Mode model) {
        List<QA> qaList = qaService.readQAPairsFromFile("path/to/qa/file.txt");
        model.addAttribute("qaList", qaList);
        return "qa"; // JSP page name
    }
}
