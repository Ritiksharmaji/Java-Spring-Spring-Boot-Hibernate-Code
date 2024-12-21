package com.blogapp.apis.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.blogapp.apis.config.AppConstants;
import com.blogapp.apis.payloads.ApiREsponse;
import com.blogapp.apis.payloads.PostDto;
import com.blogapp.apis.payloads.PostResponse;
import com.blogapp.apis.services.FileService;
import com.blogapp.apis.services.PostService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	//POST-API
	@PostMapping("/createPost/{userId}/categories/{categoryId}/posts")
	public ResponseEntity<PostDto> creatPost( @Valid @RequestBody PostDto postDto,@PathVariable("userId") int userId,
			@PathVariable("categoryId") int categoryId){
		
		PostDto createPost = this.postService.CreatePost(postDto, userId, categoryId);
		// to send the client SMS
		return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED) ;
		
	}
	
	//PUT-API
	@PutMapping("/updatePost/{postid}")
	public ResponseEntity<PostDto> UpdatePost( @Valid @RequestBody PostDto postDto,
			@PathVariable("postid") int postid){
		
		PostDto updatePost = this.postService.UpdatePost(postDto, postid);
		// to send the client SMS
		return new ResponseEntity<>(updatePost, HttpStatus.OK) ;
		
	}
	
	//GET-API (GET A DATA)
	@GetMapping("/post/{postId}")
	public ResponseEntity<PostDto> getPost(@PathVariable Integer postId){
		
		PostDto singlePost = this.postService.getPost(postId);
		
		return new ResponseEntity<PostDto>(singlePost, HttpStatus.OK) ;
		
		
	}
	
	
	//GET-API (GET ALL DATA)
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			//@RequestParam(value="pageNumber",defaultValue="0",required=false) Integer pageNumber,
			@RequestParam(value="pageNumber",defaultValue=AppConstants.PAGE_NUMBER,required=false) Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue=AppConstants.PAGE_SIZE,required=false) Integer pageSize,
			@RequestParam(value="sortBy",defaultValue=AppConstants.SORT_BY,required=false) String sortBy,
			@RequestParam(value="sortDir",defaultValue=AppConstants.SORT_DIR,required=false) String sortDir
			){
		
		// List<PostDto> allPost = this.postService.getAllPost(pageNumber,pageSize);
		PostResponse allPost = this.postService.getAllPost(pageNumber,pageSize,sortBy,sortDir);
		
		return new ResponseEntity<PostResponse>(allPost, HttpStatus.OK) ;
		
		
	}
	
	//DELETE-API (DELETE A DATA)
	@DeleteMapping("/user/posts/{postId}")
	public ApiREsponse DeletePost(@PathVariable Integer postId){
		
		this.postService.DeletePost(postId);
		
		return new ApiREsponse("Post is successfull deleted !!", true);
		
		
	}
	
	//GET-API (GET ALL POST by USER)
	@GetMapping("/user/{userID}/posts")
	public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userID){
		
		List<PostDto> postsByUser = this.postService.getPostsByUser(userID);
		
		return new ResponseEntity<List<PostDto>>(postsByUser, HttpStatus.OK) ;
		
		
	}
	
	// get post by category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<List<PostDto>> getPostsBycategory(@PathVariable Integer categoryId){
			
			List<PostDto> postsByCategory = this.postService.getPostsByCategory(categoryId);
			
			return new ResponseEntity<List<PostDto>>(postsByCategory, HttpStatus.OK) ;
			
			
		}
	
	// searching a post by title
	@GetMapping("/search/{keywords}")
	public ResponseEntity<List<PostDto>> serchPostByTitle(
			@PathVariable("keywords") String keywords
			){
		List<PostDto> searchPosts = this.postService.searchPosts(keywords);
		
		return new ResponseEntity<List<PostDto>>(searchPosts,HttpStatus.OK);
	}
	
	// this is for file section
	@PostMapping("/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadPostImage(
			@RequestParam("image") MultipartFile image,
			@PathVariable Integer postId
			) throws IOException{
		
		PostDto postDto = this.postService.getPost(postId);
		/*
		 * uploading the image to path
		 */
		String uploadImagename = this.fileService.uploadImage(path, image);
		
		/*
		 * stored image to database
		 */
		postDto.setPostImages(uploadImagename);
		PostDto updatePost = this.postService.UpdatePost(postDto, postId);
		
		return new ResponseEntity<PostDto>(updatePost,HttpStatus.OK);
		
	}
	/*
	 * handler for serve a file
	 */
	
	@GetMapping(value= "post/image/{imageName}", produces=MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable("imageName")String imageName,
			HttpServletResponse response) throws IOException{
		
		InputStream resource = this.fileService.getResource(path, imageName);
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(resource, response.getOutputStream());
	}
	
	
	
	
	
	
	
	
	
	

}
