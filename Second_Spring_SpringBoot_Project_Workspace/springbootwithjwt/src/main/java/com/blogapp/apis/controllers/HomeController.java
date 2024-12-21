package com.blogapp.apis.controllers;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blogapp.apis.model.User;
import com.blogapp.apis.service.UserResvice;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private UserResvice userResvice;

	@GetMapping("/user")
	public List<User> getuser() {

		System.out.println("userss");
		return this.userResvice.getUsers();
	}
	
	/*
     * to get the current user
     * 
     */
    @GetMapping("/current-user")
    public String getLoggedInuser(Principal principal) {
    	return principal.getName();
    }

}