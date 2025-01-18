package springMVC.controller_1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


// ---------------- step-4 create a Controller --------------------------------------------------------
@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("the home controller executed");
		return "index";
	}
	@RequestMapping("/about")
	public String about() {
		System.out.println("the about page loaded");
		return "about";
	}
	
	@RequestMapping("/controller1/home")
	public String home2() {
		System.out.println("the home controller executed");
		return "index";
	}
	@RequestMapping("/controller1/about")
	public String about2() {
		System.out.println("the about page loaded");
		return "about";
	}
	
}
