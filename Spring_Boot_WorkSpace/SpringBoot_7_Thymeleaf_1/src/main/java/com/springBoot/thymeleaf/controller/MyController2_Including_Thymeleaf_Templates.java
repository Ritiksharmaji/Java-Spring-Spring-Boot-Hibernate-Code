package com.springBoot.thymeleaf.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/api/including")
public class MyController2_Including_Thymeleaf_Templates {
	
	
	
	// handler for the conditional statements in thymeleaf
	
	@GetMapping("/include")
	public String ServiceHandler(Model model) {
	
		return "services_4";
	}
}
