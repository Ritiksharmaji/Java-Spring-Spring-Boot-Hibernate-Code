package springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import springMVC.model.QA;
import springMVC.service.QAService;

@Controller
public class QAController {

    @Autowired
    private QAService qaService;

    @GetMapping("/qa")
    public String displayQA(Model model) {
        List<QA> qaList = qaService.readQAPairsFromFile("path/to/qa/qa_data.txt");
        model.addAttribute("qaList", qaList);
        return "qa"; // JSP page name
    }
}
