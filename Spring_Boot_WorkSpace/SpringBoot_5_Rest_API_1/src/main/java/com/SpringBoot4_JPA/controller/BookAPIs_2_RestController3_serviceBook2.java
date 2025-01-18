package com.SpringBoot4_JPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.SpringBoot4_JPA.entities.Book;
import com.SpringBoot4_JPA.service.BookService_1;

import java.util.List;

@RestController
@RequestMapping("/api/books") // Base URL for all book-related endpoints
public class BookAPIs_2_RestController3_serviceBook2 {

    @Autowired
    private BookService_1 bookService;
    
    /**
     * Endpoint to get all books.
     * URL: /api/books
     * Method: GET
     * @return List of all books.
     */
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        
        return ResponseEntity.ok(books);
    }
    
    

    /**
     * Endpoint to get a single book by ID.
     * URL: /api/books/{id}
     * Method: GET
     * @param id The ID of the book to retrieve.
     * @return The book if found, or 404 if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    /**
     * Endpoint to add a new book.
     * URL: /api/books
     * Method: POST
     * @param book The book object to add.
     * @return Success response with the added book.
     */
    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book added successfully.");
    }

    /**
     * Endpoint to delete a book by ID.
     * URL: /api/books/{id}
     * Method: DELETE
     * @param id The ID of the book to delete.
     * @return Success or error response based on the operation.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        boolean isRemoved = bookService.removeBook(id);
        if (isRemoved) {
            return ResponseEntity.ok("Book deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");
        }
    }
}
