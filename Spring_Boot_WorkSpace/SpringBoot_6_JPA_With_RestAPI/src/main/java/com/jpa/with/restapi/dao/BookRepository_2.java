package com.jpa.with.restapi.dao;

// Importing CrudRepository from Spring Data JPA
import org.springframework.data.repository.CrudRepository;

import com.jpa.with.restapi.entities.Book2;

// Importing the User entity class

public interface BookRepository_2 extends CrudRepository<Book2, Integer> {
    // Interface automatically inherits CRUD methods for the User entity
    // You can add custom query methods here if needed.
	public Book2 findById(int id);
}
