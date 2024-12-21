package com.blogapp.apis.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.blogapp.apis.entities.User;
import com.blogapp.apis.exceptions.ResourceNotFoundException;
import com.blogapp.apis.repositories.UserRepo;

/*
 * in this class we are maintain the user details 
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// loading user from database by username
		
		System.out.println("this is CustomUserDetailsService.java");
		
		System.out.println("before find the user from userRepo from customUserDetails page");
		System.out.println(username);
		User userObject = this.userRepo.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("User", "Email", username));
		
		System.out.println("after find the user from userRepo from customUserDetails page");
		/*
		 * here we have the object type of user but we need to return the types of UserDetails so we need to 
		 * implemetns the UserDetails to user class so that we can return the user
		 */
		
		return userObject;
		/*
		 * after return the user object we have to authenticate the basic authentication with database so we are create a 
		 * method in SecurityConfiguration class which handle the configure the basic configuration with database in 
		 * spring boot using spring security
		 * 
		 */
	}

}
