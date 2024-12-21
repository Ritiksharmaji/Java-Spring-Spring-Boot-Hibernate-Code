package com.blogapp.apis.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.blogapp.apis.entities.Comment;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {
	
	private int postId;

	@NotEmpty(message="plz enter a title for post")
	//private String post_title;
	private String postTitle;
	
	@NotEmpty(message="plz fill the post content")
	@Size(min=5,max=1000,message=" content must be between 5 to 1000!!")
	//private String post_content;
	private String postContent;
	
	@NotEmpty(message="plz fill the image section")
	//private String post_images = "default.png" ;
	private String postImages="default.png" ;
	
	private Date addedDate;
	/*
	 * to handle the mapping
	 */
	private UserDto user;
	private CategoryDto category;
	
	/*
	 * to get related comments automatically when we call the Post
	 */
	private Set<CommentDto> comments = new HashSet<>();
	
	
	
	

}
