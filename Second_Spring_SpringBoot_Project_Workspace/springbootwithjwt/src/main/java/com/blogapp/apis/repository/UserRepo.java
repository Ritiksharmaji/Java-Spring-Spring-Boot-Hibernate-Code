package com.blogapp.apis.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogapp.apis.model.User;

public interface UserRepo  extends JpaRepository<User,String>{
	
	public Optional<User> findByEmail(String email);
}
