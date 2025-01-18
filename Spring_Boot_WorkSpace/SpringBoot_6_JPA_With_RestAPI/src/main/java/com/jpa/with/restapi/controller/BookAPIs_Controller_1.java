package com.jpa.with.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jpa.with.restapi.entities.Book;
import com.jpa.with.restapi.service.BookService_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookAPIs_Controller_1 {

    @Autowired
    private BookService_1 bookService;

    // ------------------------- GET Requests ---------------------------------------------------
    @GetMapping("/statusCode/books")
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> allBooks = this.bookService.getAllBooks();
        if (allBooks.isEmpty()) {
        	 // Return a 404 NOT FOUND response if the book is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(allBooks);
        }
    }

    @GetMapping("/statusCode/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        Book bookById = this.bookService.getBookById(id);
        if (bookById == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(bookById);
        }
    }

    

   

    // ----------------------- POST Request -----------------------------------------------------

    @PostMapping("/statusCode/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book addedBook = this.bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);
    }

    // ----------------------- DELETE Request ---------------------------------------------------

  
    @DeleteMapping("/statusCode/book/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) {
        boolean isDeleted = this.bookService.removeBook(id);
        if (isDeleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // ----------------------- PUT Request ------------------------------------------------------

   
    @PutMapping("/statusCode/book/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book updatedBook) {
        Book book = this.bookService.updateBook(id, updatedBook);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
