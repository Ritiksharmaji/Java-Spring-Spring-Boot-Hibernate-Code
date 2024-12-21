package com.blogapp.apis.services.imps;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blogapp.apis.entities.Comment;
import com.blogapp.apis.entities.Post;
import com.blogapp.apis.exceptions.ResourceNotFoundException;
import com.blogapp.apis.payloads.CommentDto;
import com.blogapp.apis.repositories.CommentRepo;
import com.blogapp.apis.repositories.PostRepo;
import com.blogapp.apis.services.CommentService;


@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto CreateComment(CommentDto commentDto, Integer postId) {
		// TODO Auto-generated method stub
		/*
		 * getting post object
		 */
		Post postObject = this.postRepo.findById(postId).
				orElseThrow(()->new ResourceNotFoundException("post" , "post Id",postId));
		/*
		 * Change the CommentDto to comment object
		 */
		Comment commentMap = this.modelMapper.map(commentDto, Comment.class);
		
		/*
		 * setting the comment fields data
		 */
		commentMap.setPost(postObject);
		commentMap.setCategory(postObject.getCategory());
		commentMap.setUser(postObject.getUser());
		
		//for testing
		System.out.println( "Post object: "+ postObject);
		System.out.println( "Post userId: "+ postObject.getUser());
		System.out.println( "Post categoryId: "+ postObject.getCategory());
		System.out.println( "Post userId: "+ commentMap.getUser());
		System.out.println( "Post categoryId: "+ commentMap.getCategory());
		
		
		Comment saveComment = this.commentRepo.save(commentMap);
		
		
		return this.modelMapper.map(saveComment, CommentDto.class);
	}

	@Override
	public void DeleteComment(Integer commentId) {
		// TODO Auto-generated method stub
		Comment commentTODelete = this.commentRepo.findById(commentId).orElseThrow(()-> 
		new ResourceNotFoundException("comment" , "comment Id",commentId));    
		this.commentRepo.delete(commentTODelete);

	}

}
