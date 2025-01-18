package com.SpringBoot4_JPA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class BookAPIs_1 {

   
   @RequestMapping(value="/old/book", method=RequestMethod.GET)
   @ResponseBody 
   public String getBook() {
        return "all books list by @RequestMapping";
    }
    
}
