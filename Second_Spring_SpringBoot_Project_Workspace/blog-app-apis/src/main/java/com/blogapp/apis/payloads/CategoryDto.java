package com.blogapp.apis.payloads;

import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	
	private int category_id;
	
	@NotEmpty(message="plz enter a title for category")
	private String category_title;
	
	@NotEmpty(message="plz enter a description for category")
	private String category_description;
	
	/*
	 * to get related comments automatically when we call the Post
	 */
	private Set<CommentDto> comments = new HashSet<>();

}
