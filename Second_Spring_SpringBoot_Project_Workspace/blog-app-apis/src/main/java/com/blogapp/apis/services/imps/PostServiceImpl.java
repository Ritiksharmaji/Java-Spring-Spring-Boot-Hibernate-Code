package com.blogapp.apis.services.imps;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.blogapp.apis.entities.Category;
import com.blogapp.apis.entities.Post;
import com.blogapp.apis.entities.User;
import com.blogapp.apis.exceptions.ResourceNotFoundException;
import com.blogapp.apis.payloads.PostDto;
import com.blogapp.apis.payloads.PostResponse;
import com.blogapp.apis.repositories.*;
import com.blogapp.apis.repositories.UserRepo;
import com.blogapp.apis.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	/*
	 * overriding the PostDto CreatePost() to create a Post
	 */
	@Override
	public PostDto CreatePost(PostDto postDto, Integer userId, Integer categoryId) {
		// TODO Auto-generated method stub
		User userObject = this.userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User" , "id",userId));
		
		Category categoryObject = this.categoryRepo.findById(categoryId).
				orElseThrow(()->new ResourceNotFoundException("Category" , "Category Id",categoryId));
		
		Post post_mapped = this.modelMapper.map(postDto, Post.class);
		
		//post_mapped.setPost_images("default.png");
		post_mapped.setPostImages("default.png");
		post_mapped.setAddedDate(new Date());
		post_mapped.setUser(userObject);
		post_mapped.setCategory(categoryObject);
		
		/*
		 * saving the post to database.
		 */
		Post savedPost = this.postRepo.save(post_mapped);
		
		return this.modelMapper.map(savedPost, PostDto.class);
	}
	
	/*
	 * overriding the PostDto UpdatePost() to Update a Post
	 */
	
	@Override
	public PostDto UpdatePost(PostDto postDto, Integer post_id) {
		// TODO Auto-generated method stub
		
		/*
		 * finding the old data to convert it new data 
		 */
		Post oldPostData = this.postRepo.findById(post_id).
		orElseThrow(()->new ResourceNotFoundException("Post" , "Post Id",post_id));
		/*
		 * setting new data
		 */
		oldPostData.setPostImages(postDto.getPostImages());
		oldPostData.setPostTitle(postDto.getPostTitle());
		oldPostData.setPostContent(postDto.getPostContent());
		/*
		 * saving the updated data to database
		 */
		Post updatedPost = this.postRepo.save(oldPostData);
		
		return this.modelMapper.map(updatedPost, PostDto.class);
	}
	
	/*
	 * overriding the void DeletePost() to Delete a Post
	 */

	@Override
	public void DeletePost(Integer post_id) {
		// TODO Auto-generated method stub
		Post postTODelete = this.postRepo.findById(post_id).orElseThrow(()-> new ResourceNotFoundException("Post" , "Post Id",post_id));    
		this.postRepo.delete(postTODelete);

	}
	
	/*
	 * overriding the PostDto getPost() to get a Post
	 */

	@Override
	public PostDto getPost(Integer post_id) {
		// TODO Auto-generated method stub
		
		Post postdata = this.postRepo.findById(post_id).
				orElseThrow(()->new ResourceNotFoundException("Post" , "Post Id",post_id));
				
		return this.modelMapper.map(postdata, PostDto.class);
	}
	
	/*
	 * overriding the List<PostDto> getAllPost() to get all Post
	 */

	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir) {	

	    //Pageable pageable = PageRequest.of(pageNumber, pageSize);
		
		/*
		 * by default it will sort the data in Ascending order  by either postId, postContent, and postTitle.
		 */
		
		//PageRequest pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
		
		/*
	     * to display the sort data in descending order
	     */
		//PageRequest pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy).descending());
	    
	/*
	* to display the sort daynemically based on user provide for that
	*/
		Sort sort = null;
		if(sortDir.equalsIgnoreCase("asc")) {
			sort = Sort.by(sortBy).ascending();
		}else {
			sort = Sort.by(sortBy).descending();
		}
		/*
	     * to display the sort data in given(either descending or asending) order
	     */
		PageRequest pageable = PageRequest.of(pageNumber, pageSize, sort);
		
		// to get the all pages post
		Page<Post> pageofPost = this.postRepo.findAll(pageable);
		
		// to get all post
		List<Post> Allcontent = pageofPost.getContent();
		
		//List<Post> allPost = this.postRepo.findAll();
		/*
		 * converting the Post object data to PostDto object data by following
		 */
		List<PostDto> CategoryDtos = Allcontent.stream().map((posts)->this.modelMapper.map(posts, PostDto.class))
				.collect(Collectors.toList());
		/*
		 * creating object for PostResponse and setting the data to it.
		 */
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(CategoryDtos);
		postResponse.setPageNumbers(pageofPost.getNumber());
		postResponse.setPageSize(pageofPost.getSize());
		postResponse.setTotalElements(pageofPost.getTotalElements());
		postResponse.setTotalPages(pageofPost.getTotalPages());
		postResponse.setLastPages(pageofPost.isLast());
		
		return postResponse;
	}
	
	/*
	 * overriding the List<PostDto> getPostsByCategory() to get all Post by particular category id
	 */

	@Override
	public List<PostDto> getPostsByCategory(Integer category_id) {
		// TODO Auto-generated method stub
		Category categoryObject = this.categoryRepo.findById(category_id).
				orElseThrow(()->new ResourceNotFoundException("Category" , "Category Id",category_id));
		/*
		 * to get the all the post by particular category
		 */
		List<Post> allPostByCategory = this.postRepo.findByCategory(categoryObject);
		/*
		 * converting the post to postDto
		 */
		List<PostDto> listOfPostDtos = allPostByCategory.stream().map((categoryposts)->this.modelMapper.
				map(categoryposts, PostDto.class)).collect(Collectors.toList());        
		
		return listOfPostDtos;
	}
	
	/*
	 * overriding the List<PostDto> getPostsByUser() to get all Post by particular user id
	 */

	@Override
	public List<PostDto> getPostsByUser(Integer user_id) {
		// TODO Auto-generated method stub
		
		User userObject = this.userRepo.findById(user_id).
				orElseThrow(()->new ResourceNotFoundException("User" , "id",user_id));
		/*
		 * to get the all the post by particular user
		 */
		List<Post> allPostByUser = this.postRepo.findByUser(userObject);
		/*
		 * converting the post to postDto
		 */
		List<PostDto> listOfPostdtoByUser = allPostByUser.stream().map((userposts)->this.modelMapper.
				map(userposts, PostDto.class)).collect(Collectors.toList());        
		return listOfPostdtoByUser;
	}
	
	/*
	 * overriding the List<PostDto> searchPosts() to search a particular post
	 */


	@Override
	public List<PostDto> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		List<Post> byTitleContaining = this.postRepo.findByPostTitleContaining(keyword);
		/*
		 * conveting post object to postDto
		 */
		 List<PostDto> collectList = byTitleContaining.stream().map((posts)->
		 this.modelMapper.map(posts, PostDto.class)).collect(Collectors.toList());         
		return collectList;
	}

	

	
	

}
