package com.blogapp.apis.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blogapp.apis.model.JWTRequest;
import com.blogapp.apis.model.JWTResponse;
import com.blogapp.apis.model.User;
import com.blogapp.apis.repository.UserRepo;
import com.blogapp.apis.security.JwtHelper;
import com.blogapp.apis.service.UserResvice;

@RestController
@RequestMapping("/auth")
public class AuthController {

	 @Autowired
	    private UserDetailsService userDetailsService;

	    @Autowired
	    private AuthenticationManager manager;


	    @Autowired
	    private JwtHelper helper;
	    
	    @Autowired
	    private UserResvice userService;

	    private Logger logger = LoggerFactory.getLogger(AuthController.class);


	    @PostMapping("/login")
	    public ResponseEntity<JWTResponse> login(@RequestBody JWTRequest request) {
	    	System.out.println("-------part-1:--Login------------------");
	        this.doAuthenticate(request.getEmail(), request.getPassword());

	        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
	        
	        System.out.println("-------ater custum service: user:-"+userDetails);
	
	        String token = this.helper.generateToken(userDetails);

	        JWTResponse response = JWTResponse.builder()
	                .jwtToken(token)
	                .username(userDetails.getUsername()).build();
	        return new ResponseEntity<>(response, HttpStatus.OK);
	    }

	    private void doAuthenticate(String email, String password) {

	    	System.out.println("-------part-2:--doAuthenticate------------------");
	        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
	        try {
	            manager.authenticate(authentication);
	            System.out.println("-------part-3b:--after authentication manager------------------");

	        } catch (BadCredentialsException e) {
	            throw new BadCredentialsException(" Invalid Username or Password  !!");
	        }

	    }

	    @ExceptionHandler(BadCredentialsException.class)
	    public String exceptionHandler() {
	        return "Credentials Invalid !!";
	    }
    
    @PostMapping("/create-user")
    public User createUser(@RequestBody User user) {
    	
    	return userService.createUser(user);
    	
    }
    
    
    
    
    
    
    

}
