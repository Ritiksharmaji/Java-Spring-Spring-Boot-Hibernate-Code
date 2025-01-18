package com.SpringBoot4_JPA;
import java.util.List;
import java.util.Optional;

// Importing Spring Boot and related dependencies
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// Importing the custom UserRepository interface and User entity class
import com.SpringBoot4_JPA.Dao_1.UserRepository;
import com.SpringBoot4_JPA.entities_1.User;

@SpringBootApplication
public class SpringBoot4JpaApplication_2 {

    public static void main(String[] args) {
        // Initializing the Spring application and getting the application context
        ApplicationContext context = SpringApplication.run(SpringBoot4JpaApplication_2.class, args);

        // Fetching the UserRepository bean from the application context
        UserRepository userRepo = context.getBean(UserRepository.class);
// ---------------------------- insert operation -------------------------------------------------------------------------------------------
        // Creating a multiple user entity and setting its properties
        User user = new User();
        User user2 = new User();
        User user3 = new User();
        
        user.setName("first user name");   
        user.setCity("first user city");        
        user.setStatus("first user status"); 
        
        user2.setName("second user name");   
        user2.setCity("second user city");       
        user2.setStatus("second user status"); 
        
        user3.setName("third user name");   
        user3.setCity("third city name");       
        user3.setStatus("hird user status"); 
        
        // Saving the User entity to the database using UserRepository
        User savedUser = userRepo.save(user);
        
        // Printing the saved User entity to verify the operation
   	 		System.out.println(savedUser);
       
   	 	List<User> listOfUsers = List.of(user2,user3);
        Iterable<User> saveAllDataIntoDatabase = userRepo.saveAll(listOfUsers);
     // Printing the saved User entity to verify the operation
	 		System.out.println(saveAllDataIntoDatabase);

// ------------------------------- update operation ------------------------------------------------------------------------------------
//	 
//     // Attempting to fetch a user by their ID (in this case, ID = 5) using the findById() method.
//     // The findById() method returns an Optional<User> that may contain the User object if found, or be empty if not.
//     Optional<User> findAData = userRepo.findById(5);
//
//     // Checking if the Optional contains a value (i.e., the user exists in the database).
//     if (findAData.isPresent()) { 
//         // Extracting the User object from the Optional using the get() method.
//         User user = findAData.get();
//
//         // Updating the user's properties with new values.
//         user.setName("update third name");      // Updating the name
//         user.setCity("update third city");      // Updating the city
//         user.setStatus("update third status");  // Updating the status
//
//         // Saving the updated user object back to the database using the save() method.
//         // This performs an update operation since the user already exists (identified by its primary key).
//         User updatedData = userRepo.save(user);
//
//         // Printing the updated user object to verify the changes.
//         System.out.println(updatedData);
//     } else {
//         // If the Optional is empty (user not found), this block is executed.
//         System.out.println("User ID does not exist in the database");
//     }

        
// ---------------------------------- GET a USER AND GET ALL THE USER ----------------------------------------------------------
//     // Get a specific user by ID
//        int userId = 5; // Replace with the ID you want to fetch
//        Optional<User> userOptional = userRepo.findById(userId);
//
//        // Check if the user exists
//        if (userOptional.isPresent()) {
//            User user = userOptional.get(); // Retrieve the User object from the Optional
//            System.out.println("User Found: " + user);
//        } else {
//            System.out.println("User with ID " + userId + " does not exist.");
//        }
//
//        // Get all users from the database
//        Iterable<User> allUsers = userRepo.findAll();
//
//        // Check if users exist and iterate through the list of users
//        System.out.println("List of all users:");
//        for (User user : allUsers) {
//            System.out.println(user);
//        }
        
        
// -------------------------- DELETE A USER AND DELETE ALL THE USER ------------------------------------------------------
//     // Delete a specific user by ID
//        int userIdToDelete = 5; // Replace with the ID you want to delete
//        Optional<User> userOptional = userRepo.findById(userIdToDelete);
//
//        if (userOptional.isPresent()) {
//            // If the user exists, delete the user
//            userRepo.deleteById(userIdToDelete);
//            System.out.println("User with ID " + userIdToDelete + " deleted successfully.");
//        } else {
//            // If the user does not exist, print a message
//            System.out.println("User with ID " + userIdToDelete + " does not exist.");
//        }
//
//        // Delete all users from the database
//        System.out.println("Deleting all users...");
//        userRepo.deleteAll();
//        System.out.println("All users deleted successfully.");
//        
        
    }
}
