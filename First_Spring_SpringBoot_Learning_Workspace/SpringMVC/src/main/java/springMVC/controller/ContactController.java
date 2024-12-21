package springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springMVC.model.User;
import springMVC.service.UserService;

@Controller
public class ContactController {

	@Autowired
	private UserService userSevice;

	@ModelAttribute
	public void common(Model model) {
		model.addAttribute("Header", "LearnCodeWith-Ritik");
		model.addAttribute("desc", "Happy Learning");
	}

	@RequestMapping("/contact")
	public String getContact(Model model) {

		return "contact";
	}

	// ----------Using by @ModelAttribute Annotation ---------------
	@RequestMapping(path = "/poccessForm", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute User user, Model model) {
		System.out.println(user);
		// apply the Redirect concept here

		if (user.getName().isBlank()) {
			System.out.println("username not available");
			return "redirect:/contact";
		} else if (user.getEmail().isBlank()) {
			System.out.println("useremail not available");
			return "redirect:/contact";
		} else if (user.getPassword().isBlank()) {
			System.out.println("userPassword not available");
			return "redirect:/contact";
		}
		// model.addAttribute("userdetails", user);

		int user2 = this.userSevice.createUser(user);
		model.addAttribute("msg", "user created with id: " + user2);
		return "Success";
	}

	// @RequestMapping(path="/poccessForm",method=RequestMethod.POST)
	// public String handleForm(HttpServletRequest request) {
	//
	// String parameter = request.getParameter("name");
	// System.out.println(parameter);
	// return "";
	//
	// }

	// @RequestMapping(path="/poccessForm",method=RequestMethod.POST)
	// public String handleForm(
	// @RequestParam("name") String userName,
	// @RequestParam("email")String useremai,
	// @RequestParam("password")String userPassword,
	// Model model) {
	//
	// System.out.println("user name: "+ userName);
	// System.out.println("user email: "+ useremai);
	// System.out.println("user passwowrd: "+ userPassword);
	// //setting data to Model object so we can fatch it to other pages
	//// model.addAttribute("user_password", userPassword);
	//// model.addAttribute("user_name", userName);
	//// model.addAttribute("user_email", useremai);
	// User user =new User();
	// user.setEmail(useremai);
	// user.setName(userName);
	// user.setPassword(userPassword);
	// System.out.println(user);
	// // to setting data to model object
	// model.addAttribute("userdetails", user);
	//
	// return "Success";
	//
	// }

}
