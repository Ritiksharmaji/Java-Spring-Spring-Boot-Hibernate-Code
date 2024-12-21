package com.apringboot.api.springbootapi.Dao;

import org.springframework.data.repository.CrudRepository;

import com.apringboot.api.springbootapi.entities.Book;
import java.util.List;

// to get the all the method of JPA for database operation we need to extends the a interface of JPA
public interface BookRepository extends CrudRepository<Book, Integer> {
    // declare a method

    public Book findById(int id);

}
