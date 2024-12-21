package com.blogapp.apis.services;

import java.util.List;
import com.blogapp.apis.payloads.PostDto;
import com.blogapp.apis.payloads.PostResponse;

public interface PostService {

	// create
	public PostDto CreatePost(PostDto postDto,Integer userId,Integer categoryId);
	// update
	public PostDto UpdatePost(PostDto postDto,Integer post_id);           
	// delete
	public void DeletePost(Integer post_id);
	//get a single post
	public PostDto getPost(Integer post_id);
	
	// get all post
	//public List<PostDto> getAllPost();
	//public List<PostDto> getAllPost(Integer pageNumber, Integer pageSize);
	//public PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy);
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);
	
	//get all posts by category
	public List<PostDto> getPostsByCategory(Integer category_id);
	
	// get all posts by user
	public List<PostDto> getPostsByUser(Integer user_id);
	
	//search a posts
	List<PostDto> searchPosts(String keyword);
}
