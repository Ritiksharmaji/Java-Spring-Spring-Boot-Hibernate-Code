package com.springboot.Thymeleaf.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ThymleafController {
	
	// creating handler
	@RequestMapping(value="/cont", method= RequestMethod.GET)
	public String getBasic(Model model) {
		
		System.out.println("this is user controller for Thymleaf");
		model.addAttribute("name","Riitk sharma");
		model.addAttribute("ceoName", "Ankit sharma");
		model.addAttribute("date", new Date());
		return "contact";
		// here basically we are calling the contact.html not a contact.jsp
	}
	
	// this handler for iterate features 
	@GetMapping("/get-iterator")
	public String getIterator(Model m) {
		
		List<String> of = List.of("Ritik sharam","Ankit sharma","Priyanshu sharma",
				"Shyam babu sharma","mahima");
		m.addAttribute("FamilyList", of);
		
		return "iteratorPage";
	}

}
