package com.jpa.with.restapi.dao;

// Importing CrudRepository from Spring Data JPA
import org.springframework.data.repository.CrudRepository;

import com.jpa.with.restapi.entities.Book;

// Importing the User entity class

public interface BookRepository_1 extends CrudRepository<Book, Integer> {
    // Interface automatically inherits CRUD methods for the User entity
    // You can add custom query methods here if needed.
	public Book findById(int id);
}
