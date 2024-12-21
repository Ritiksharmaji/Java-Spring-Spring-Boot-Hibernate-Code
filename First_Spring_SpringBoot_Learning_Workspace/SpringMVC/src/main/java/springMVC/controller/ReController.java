package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ReController {
	
//	@RequestMapping("/first")
//	public String First() {
//		
//		System.out.println("first executed");
//		return "redirect:/error";
//	}
	
	//----------by  RedirectView     -----------------------
	@RequestMapping("/redirect")
	public RedirectView First() {
		
		System.out.println("redirect executed");
		//creating object for RedirectView
		RedirectView redirectView = new RedirectView();
		// calling SetUrl method of redirectView to set the URL
		redirectView.setUrl("error");
		return redirectView;
	}
	
	@RequestMapping("/second")
	@ResponseBody
	public String Second() {
		
		System.out.println("Second Executed");
		return "this is second method";
	}
	
	@RequestMapping("/error")
	@ResponseBody
	public String Eroor() {
		
		System.out.println("error method executed");
		return "somthing went wrong [Error page]!!";
	}

}
