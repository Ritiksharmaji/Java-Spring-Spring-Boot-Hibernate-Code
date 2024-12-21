package com.blogapp.apis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.blogapp.apis.repositories.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	private UserRepo userRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void TestOfReposityInterface() {
		
		String className = this.userRepo.getClass().getName();
		Package classPackageName = this.userRepo.getClass().getPackage();   
		System.out.println(classPackageName);
		System.out.println(className);
		
	}

}
