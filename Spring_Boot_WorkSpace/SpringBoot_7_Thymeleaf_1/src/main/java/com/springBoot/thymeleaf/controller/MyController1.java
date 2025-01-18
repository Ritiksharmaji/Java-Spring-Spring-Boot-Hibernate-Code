package com.springBoot.thymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class MyController1 {
	
	@RequestMapping(value="/about", method= RequestMethod.GET)
	public String about(Model model) {
		
		model.addAttribute("name", "Ritik sharma");
		model.addAttribute("age", 24);
		System.out.println("Inside about handler");
		
		return "about";
		
	}
	
	@GetMapping("example-iterate")
	public String iterateHandler(Model model) {
		
		List<String> listOfData = List.of("Ankit sharma", "Ritik sharma", "Mahima Sharma", "Priyanshu sharma",
				"Mamta devi", "Shyam Babu Sharma");
		
		model.addAttribute( "allNames",listOfData);
		
		return "iterate";
	}
	
	
	// handler for the conditional statements in thymeleaf
	@GetMapping("example-conditinal")
	public String ConditionalStatement(Model model) {
		System.out.println("this is the ConditionalStatement handlar ");
		
		// this is for Elvis type of conditional statements
		model.addAttribute("isActive", false);
		
		// this is for if-Unless type of conditional statements
		model.addAttribute("gender", "male");
		
		// this is for switch 
		
		List<Integer> listOfInteger = List.of(123,342,456,333,564,222);
		
		model.addAttribute("mylist",listOfInteger);
		
		return "conditinal_3";
	}

}
