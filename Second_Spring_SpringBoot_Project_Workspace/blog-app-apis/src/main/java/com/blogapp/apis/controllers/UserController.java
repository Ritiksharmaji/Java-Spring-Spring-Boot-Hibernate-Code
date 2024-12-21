package com.blogapp.apis.controllers;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blogapp.apis.payloads.ApiREsponse;
import com.blogapp.apis.payloads.UserDto;
import com.blogapp.apis.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//post - for create a user
	
	@GetMapping("/ritik")
	public String getString() {
		return "hello ritik sharma";
	}
	/*
	 * here we are using the UserDto to transfere the data beacuses 
	 * to security purpuse we are not using the user class directly
	 * for that we had created two method to change the data form 
	 * userDto class to user class
	 */
	@PostMapping("/createUser")
	public ResponseEntity<UserDto> creatUser( @Valid @RequestBody UserDto userDto){
		
		UserDto created_User = this.userService.createUser(userDto);
		// to send the client SMS
		return new ResponseEntity<>(created_User, HttpStatus.CREATED) ;
		
	}
	// put- for update a user
	
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<UserDto> UpdateUser( @Valid @RequestBody UserDto userDto,@PathVariable("id") int id){
		
		UserDto updateUser = this.userService.updateUser(userDto,id );
		
		return ResponseEntity.ok(updateUser);
	}
	
	// delete - for delete a user
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/DeleteUser/{userId}")
	public ResponseEntity<ApiREsponse> userDeleteApi(@PathVariable("userId") Integer uid){
		this.userService.deleteUser(uid);
		//return new  ResponseEntity(Map.of("message","User deleted successfully"), HttpStatus.OK);
	return new ResponseEntity<ApiREsponse>(new ApiREsponse("user Deleted successfully", true),HttpStatus.OK);
	}
	
	// get - all the users
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		
		List<UserDto> allUsers = this.userService.getAllUsers();
	
	return  ResponseEntity.ok(allUsers);
	}
	
	
	// get user by id 
	@GetMapping("/user/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable("userId") Integer userId){
		
		  UserDto userById = this.userService.getUserById(userId);
	
	return  ResponseEntity.ok(userById);
	}

}
