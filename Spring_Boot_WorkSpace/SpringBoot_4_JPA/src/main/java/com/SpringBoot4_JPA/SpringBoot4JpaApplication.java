package com.SpringBoot4_JPA;

// Importing Spring Boot and related dependencies
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// Importing the custom UserRepository interface and User entity class
import com.SpringBoot4_JPA.Dao_1.UserRepository;
import com.SpringBoot4_JPA.entities_1.User;

/**
 * Main class for the Spring Boot application.
 * 
 * - Annotated with @SpringBootApplication, which marks it as the entry point for the application.
 * - The application context is initialized using SpringApplication.run().
 * - Demonstrates basic usage of a CrudRepository by saving a user entity into the database.
 */
@SpringBootApplication
public class SpringBoot4JpaApplication {

    public static void main(String[] args) {
        // Initializing the Spring application and getting the application context
        ApplicationContext context = SpringApplication.run(SpringBoot4JpaApplication.class, args);

        // Fetching the UserRepository bean from the application context
        UserRepository userRepo = context.getBean(UserRepository.class);

        // Creating a new User entity and setting its properties
        User user = new User();
        user.setName("Ankit Sharma");   // Setting the user's name
        user.setCity("ushri");        // Setting the user's city
        user.setStatus("I am a full developer"); // Setting the user's status

        // Saving the User entity to the database using UserRepository
        User savedUser = userRepo.save(user);

        // Printing the saved User entity to verify the operation
        System.out.println(savedUser);
    }
}
