package com.springBoot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

}
