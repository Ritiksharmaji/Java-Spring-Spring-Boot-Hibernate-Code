package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestControllerByStS {
    
    @RequestMapping("/test")
    public String firstHandler() {
        System.out.print("this is testing page for /test url:");
        return "home"; // This will resolve to /views/home.jsp
    }
}