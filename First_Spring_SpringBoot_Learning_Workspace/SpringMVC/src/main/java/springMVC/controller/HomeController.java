package springMVC.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home(Model model) {
		System.out.println("the home controller executed");
		// adding the data using model
		model.addAttribute("name","Ritik sharma ji");
		model.addAttribute("number", 90);
		//ArrayList type
		List<String> friends = new ArrayList<String>();
		friends.add("Ankit sharma");
		friends.add("Abhi");
		friends.add("khushi");
		//model.addAllAttributes(friends);
		model.addAttribute("friends", friends);
		
		return "index";
	}
	@RequestMapping("/about")
	public String about() {
		System.out.println("the about page loaded");
		return "about";
	}
	
	// for  using ModelAndView
	@RequestMapping("/help")
	public ModelAndView help() {
		System.out.println("this is help controller");
		// creating object for ModelAndView
		ModelAndView MAV = new ModelAndView();
		//setting data to object of ModelAndView
		MAV.addObject("name", "Ankit sharma");
		MAV.addObject("roll", "211FJ01050");
		// for list types
		List<Integer> marks = new ArrayList<Integer>();
		marks.add(101);
		marks.add(120);
		marks.add(130);
		marks.add(140);
		MAV.addObject("marks", marks);
		//setting view to display the data
		MAV.setViewName("help");
		return MAV;
	}

}
