package com.blogapp.apis;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.blogapp.apis.config.AppConstants;
import com.blogapp.apis.entities.Role;
import com.blogapp.apis.repositories.RoleRepo;

@SpringBootApplication
@EnableWebSecurity
public class BlogAppApisApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}
	
	@Autowired
	private RoleRepo roleRepo;
	
	/*
	 * 
	 * creating a method which has return types of ModelMapper
	 * to handle the converting one object to other 
	 */
	
	@Bean
	public ModelMapper modelMapper() {
		
		return new ModelMapper(); 
	}
	
//	public void run(String... args) throws Exception{
//		
//		System.out.println("for role main class");
//		try {
//			
//			Role role = new Role();
//			role.setId(AppConstants.ADMIN_USER);
//			role.setName("ROLE_ADMIN");
//			
//			Role role2 = new Role();
//			role2.setId(AppConstants.NORMAL_USER);
//			role2.setName("ROLE_NORMAL");
//			/*
//			 * TO store it into database
//			 */
//			List<Role> roleList = List.of(role,role2);
//			
//			List<Role> savedRole = this.roleRepo.saveAll(roleList);
//			/*
//			 * to display the role name in console
//			 */
//			savedRole.forEach(r->{
//				System.out.println(r.getName());
//			});
//			
//		}catch(Exception e) {
//			System.out.println("error in role:"+ e);
//		}
//	}
	
	


	public void run(String... args) throws Exception{

		System.out.println("for role main class");
		try {

			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName("ROLE_ADMIN");

			Role role2 = new Role();
			role2.setId(AppConstants.NORMAL_USER);
			role2.setName("ROLE_NORMAL");
			/*
			 * TO store it into database
			 */
			List<Role> roleList = List.of(role,role2);

			List<Role> savedRole = this.roleRepo.saveAll(roleList);
			/*
			 * to display the role name in console
			 */
			savedRole.forEach(r->{
				System.out.println(r.getName());
			});

		}catch(Exception e) {
			System.out.println("error in role:"+ e);
		}
	}
	

}
