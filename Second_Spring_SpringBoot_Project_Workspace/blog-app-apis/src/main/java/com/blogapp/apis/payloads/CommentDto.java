package com.blogapp.apis.payloads;

import com.blogapp.apis.entities.Category;
import com.blogapp.apis.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CommentDto {

	
	private int commentId;
	private String content;
//	private UserDto user;
//	private CategoryDto category; 
	
}
