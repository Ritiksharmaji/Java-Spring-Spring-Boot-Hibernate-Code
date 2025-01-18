package com.SpringBoot4_JPA.Dao_1;

import java.util.List;
// Importing CrudRepository from Spring Data JPA
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Importing the User entity class
import com.SpringBoot4_JPA.entities_1.User;

@Repository
public interface UserRepository_2_CustomFInderMethod_2 extends CrudRepository<User, Integer> {

    // Find users by name
    List<User> findByName(String name);

    // Find users by city
    List<User> findByCity(String city);

    // Find users by name and city
    List<User> findByNameAndCity(String name, String city);

    // Find users with names containing a specific string (case insensitive)
    List<User> findByNameContainingIgnoreCase(String keyword);

    // Find users with status starting with a specific string
    List<User> findByStatusStartingWith(String prefix);

    // Find users where the name is "null"
    List<User> findByNameIsNull();

    // Find users where the city is not null
    List<User> findByCityIsNotNull();
}
