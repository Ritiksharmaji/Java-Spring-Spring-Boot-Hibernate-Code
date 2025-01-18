package com.SpringBoot4_JPA;

import java.util.List;
// Importing Spring Boot and related dependencies
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.SpringBoot4_JPA.Dao_1.UserRepository_2_CustomFInderMethod_2;
// Importing the custom UserRepository interface and User entity class
import com.SpringBoot4_JPA.entities_1.User;

@SpringBootApplication
public class SpringBoot4JpaApplication_4 {

    public static void main(String[] args) {
        // Initializing the Spring application and getting the application context
        ApplicationContext context = SpringApplication.run(SpringBoot4JpaApplication_4.class, args);

        UserRepository_2_CustomFInderMethod_2 userRepo = context.getBean(UserRepository_2_CustomFInderMethod_2.class);

        // Find users by name
        List<User> usersByName = userRepo.findByName("John Doe");
        System.out.println("this is for findByName");
        usersByName.forEach(System.out::println);

        // Find users by city
        List<User> usersByCity = userRepo.findByCity("New York");
        System.out.println("this is for findByCity");
        usersByCity.forEach(System.out::println);

        // Find users by name and city
        List<User> usersByNameAndCity = userRepo.findByNameAndCity("Alice", "Los Angeles");
        System.out.println("this is for  Find users by name and city");
        usersByNameAndCity.forEach(System.out::println);

        // Find users with a name containing a keyword
        List<User> usersByKeyword = userRepo.findByNameContainingIgnoreCase("developer");
        System.out.println("this is for  Find users with a name containing a keyword");
        usersByKeyword.forEach(System.out::println);

        // Find users with status starting with "active"
        List<User> usersByStatus = userRepo.findByStatusStartingWith("active");
        System.out.println("this is for  Find users with status starting with \"active\"");
        usersByStatus.forEach(System.out::println);
    }
}