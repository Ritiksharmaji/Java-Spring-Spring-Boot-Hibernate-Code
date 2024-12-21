package com.blogapp.apis.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.blogapp.apis.entities.*;

public interface PostRepo extends JpaRepository<Post , Integer> {

	/*
	 * creating JPA costume method 
	 */
	List<Post>findByUser(User user);
	List<Post>findByCategory(Category category);
	/*
	 * creating costume method for searching this findByTitleContaining(String title) will implemets the like query
	 */
	
	List<Post> findByPostTitleContaining(String postTitle);
	/*
	 * we can also create a user method with query for search
	 */
	
//	@Query("select post_title from Post where p.post_title like:key")
//	List<Post>serarchByTitle( @Param("")String postTitle);
}

