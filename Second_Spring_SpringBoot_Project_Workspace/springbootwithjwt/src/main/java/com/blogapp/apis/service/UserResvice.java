package com.blogapp.apis.service;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.blogapp.apis.repository.UserRepo;
import com.blogapp.apis.model.User;

@Service
public class UserResvice {

	//private List<User> store = new ArrayList<>();

	@Autowired
	 UserRepo userRepo;
	
	@Autowired
	private PasswordEncoder  passwordEncorder;
	
	

	public List<User> getUsers() {
		//return this.store;
		return userRepo.findAll();
	}
	
	public User createUser(User user) {
		user.setUserId(UUID.randomUUID().toString());
		
		/*
		 * to store the encoder password in database.
		 */
		user.setPassword(this.passwordEncorder.encode(user.getPassword()));
		return userRepo.save(user);
	}
	
	
	
	
	
	
	
}
