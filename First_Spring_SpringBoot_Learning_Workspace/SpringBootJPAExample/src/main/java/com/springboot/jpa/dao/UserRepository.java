package com.springboot.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springboot.jpa.entities.User;

public interface UserRepository  extends CrudRepository<User,Integer>{
	
	// this is custom method which is already define by java
	public  List<User> findByName(String name);
	public List<User> findByNameAndCity(String name,String city);
	public List<User> findByNameOrCity(String name,String city);
	
	@Query("SELECT u FROM User u ")
	public List<User> getAllUser();
	
	@Query("Select u from User u where u.name =:n")
	// name is User class name
	public List<User> getUserByName(@Param("n") String name);

}
