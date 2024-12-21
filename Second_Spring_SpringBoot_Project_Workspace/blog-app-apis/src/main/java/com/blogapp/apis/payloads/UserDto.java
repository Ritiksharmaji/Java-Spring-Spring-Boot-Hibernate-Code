package com.blogapp.apis.payloads;

import java.util.HashSet;
import java.util.Set;

import com.blogapp.apis.entities.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
/*
 * this class can communicate with userService class and after all successful data 
 * it will goes to communicate with user class.
 */
public class UserDto {
	
	private int id;
	/*
	 * here @NotNull define only for null and @NotEmpty
	 * define for all either null value and black
	 */
	//@NotNull
	@NotEmpty
	@Size(min=3, max=100,message="name charecter must be 2 to 100 char!!")
	private String name;
	
	@Email(message="provided Email id not valid !!")
	@NotEmpty
	private String email;
	
	@NotEmpty(message= " password can't be  empty")
	@Size(min=6,max=50,message="password must be between 6 to 50 char!!")
	private String password;
	
	@NotEmpty(message="plz fill about your selph")
	private String about;
	

	/*
	 * to get related comments automatically when we call the Post
	 */
	private Set<CommentDto> comments = new HashSet<>();
	
	/*
	 * to define the user Role.
	 */
	private Set<RoleDto> roles = new HashSet<>();
}
