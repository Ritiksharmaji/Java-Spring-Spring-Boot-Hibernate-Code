package com.blogapp.apis.controllers;

import java.util.UUID;

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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blogapp.apis.security.JWTTokenHelper;
import com.blogapp.apis.security.JwtHelper;
import com.blogapp.apis.entities.User;
import com.blogapp.apis.payloads.JWTRequest;
import com.blogapp.apis.payloads.JWTResponse;
import com.blogapp.apis.payloads.UserDto;
import com.blogapp.apis.services.UserService;
import com.blogapp.apis.services.imps.UserServiceImpl;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/v1")
//@CrossOrigin
public class AuthController {


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;


    @Autowired
    private JwtHelper helper;
    
    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);


    @PostMapping("/login")
    public ResponseEntity<JWTResponse> login( @Valid @RequestBody JWTRequest request) {
    	System.out.println("-------part-1:--Login------------------");
    	
    	System.out.println("thi is request from login:"+ request);
    	
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
            throw new BadCredentialsException("Invalid Username or Password !!");
        }

    }

//    @ExceptionHandler(BadCredentialsException.class)
//    public String exceptionHandler() {
//        return "Invalid Username or Password  !!";
//    }
    
    
    @PostMapping("/create-user")
    public UserDto createUser(@RequestBody UserDto user) {
    	
    	return userService.createUser(user);
    	
    }
    
    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userDto){
		
    	UserDto registerNewUser = this.userService.registerNewUser(userDto);
    	
    	return new ResponseEntity<UserDto>(registerNewUser,HttpStatus.CREATED);
    	
    }
    
   
}
