package com.blogapp.apis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blogapp.apis.payloads.ApiREsponse;
import com.blogapp.apis.payloads.CommentDto;
import com.blogapp.apis.services.CommentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/comments")
public class CommentContoller {
	
	@Autowired
	private CommentService commentService;
	
	
	// POST API
	//@PostMapping("user/{userId}/category/{categoryId}/post/{postId}/createComment")
		@PostMapping("/post/{postId}/createComment")
		public ResponseEntity<CommentDto> creatComment( @Valid @RequestBody CommentDto comment,
				@PathVariable("postId") Integer PostId){
		
			CommentDto createComment = this.commentService.CreateComment(comment, PostId);
			
			return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED) ;	
		}
		
		
		
  // DELETE API
		@DeleteMapping("/comments/{commentId}")
		public ResponseEntity<ApiREsponse> DeleteComment( @Valid @PathVariable Integer commentId){
		
			this.commentService.DeleteComment(commentId);
			
			return new ResponseEntity<ApiREsponse>(new ApiREsponse("Comment delete sucessfully",true),HttpStatus.OK) ;	
		}

}
