package com.blogapp.apis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blogapp.apis.model.User;
import com.blogapp.apis.repository.UserRepo;



@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// loading user from database by username
		
		User userObject = this.userRepo.findByEmail(username).orElseThrow(()->new RuntimeException("user not found"));
		
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
