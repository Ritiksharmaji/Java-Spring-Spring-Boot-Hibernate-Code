package springMVC.controller_2;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


// ---------------- step-4 create a Controller --------------------------------------------------------
// sending the data from the controller to view using the Model class object 
@Controller
public class HomeController {
	
	@RequestMapping("/controller2/home")
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
		
		return "index2";
	}
	@RequestMapping("/controller2/about")
	public String about() {
		System.out.println("the about page loaded");
		return "about2";
	}

//-------------------------- sending the data from the controller to view using the ModelAndView class object --------------------
	// for  using ModelAndView
		@RequestMapping("/controller2/help")
		public ModelAndView help() {
			System.out.println("this is help controller");
			// creating object for ModelAndView to return it otherwise it can't be return anything
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
			MAV.setViewName("help2");
			return MAV;
		}
	
	
	
}
