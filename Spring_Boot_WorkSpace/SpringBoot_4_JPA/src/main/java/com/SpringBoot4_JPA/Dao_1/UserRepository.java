package com.SpringBoot4_JPA.Dao_1;

// Importing CrudRepository from Spring Data JPA
import org.springframework.data.repository.CrudRepository;

// Importing the User entity class
import com.SpringBoot4_JPA.entities_1.User;

/**
 * UserRepository interface that extends CrudRepository.
 * 
 * CrudRepository provides generic CRUD (Create, Read, Update, Delete)
 * operations for the specified entity type (User) and its primary key type (Integer).
 * 
 * Key Points:
 * - No need to implement methods like save(), findById(), delete(), etc., as they are provided out of the box.
 * - You can define custom query methods by following Spring Data JPA method naming conventions.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    // Interface automatically inherits CRUD methods for the User entity
    // You can add custom query methods here if needed.
}
