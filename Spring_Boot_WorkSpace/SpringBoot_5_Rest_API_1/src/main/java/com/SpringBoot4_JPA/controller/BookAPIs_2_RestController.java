package com.SpringBoot4_JPA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookAPIs_2_RestController {

    @GetMapping("/rest/")
    public String home() {
        return "Welcome to the Book API with RestController!";
    }

    @GetMapping("/rest/book")
    public String getBook() {
        return "a books details by RestController method";
    }
    
   @RequestMapping(value="/rest/books", method=RequestMethod.GET)
   public String getBooks_ByOld() {
        return "all books list by RestController method";
    }
    
}
