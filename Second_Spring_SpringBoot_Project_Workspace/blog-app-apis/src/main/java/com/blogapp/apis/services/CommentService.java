package com.blogapp.apis.services;

import com.blogapp.apis.payloads.CommentDto;

public interface CommentService {
	
	public CommentDto CreateComment(CommentDto commentDto, Integer postid);                  

	void DeleteComment(Integer commentId);
	//etc...
}
