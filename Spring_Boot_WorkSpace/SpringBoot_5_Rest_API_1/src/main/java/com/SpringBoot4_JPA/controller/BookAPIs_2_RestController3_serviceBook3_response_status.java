package com.SpringBoot4_JPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.SpringBoot4_JPA.entities.Book;
import com.SpringBoot4_JPA.service.BookService_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookAPIs_2_RestController3_serviceBook3_response_status {

    @Autowired
    private BookService_1 bookService;

    // ------------------------- GET Requests ---------------------------------------------------
    
    /**
     * Endpoint to get all dynamic books.
     * Returns a 404 NOT FOUND status if no books are found, otherwise returns the list of books with a 200 OK status.
     */
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

    /**
     * Endpoint to get a dynamic book by its ID.
     * Returns a 404 NOT FOUND status if the book is not found, otherwise returns the book with a 200 OK status.
     */
    @GetMapping("/statusCode/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        Book bookById = this.bookService.getBookById(id);
        if (bookById == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } else {
            return ResponseEntity.ok(bookById);
        }
    }

    /**
     * Endpoint to get all static books.
     * Always returns the list of static books with a 200 OK status.
     */
    @GetMapping("/statusCode/static/books")
    public ResponseEntity<List<Book>> getStaticBooks() {
        List<Book> staticBooks = BookService_1.getStaticBooks();
        return ResponseEntity.ok(staticBooks);
    }

    /**
     * Endpoint to get all books (dynamic + static).
     * Combines both lists and returns with a 200 OK status.
     */
    @GetMapping("/statusCode/all/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> staticBooks = BookService_1.getStaticBooks();
        List<Book> dynamicBooks = this.bookService.getAllBooks();

        List<Book> allBooks = new ArrayList<>();
        allBooks.addAll(staticBooks);
        allBooks.addAll(dynamicBooks);

        return ResponseEntity.ok(allBooks);
    }

    // ----------------------- POST Request -----------------------------------------------------

    /**
     * Endpoint to add a new book.
     * Returns the added book with a 201 CREATED status.
     */
    @PostMapping("/statusCode/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book addedBook = this.bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);
    }

    // ----------------------- DELETE Request ---------------------------------------------------

    /**
     * Endpoint to delete a book by its ID.
     * Returns a 200 OK status if the book was deleted successfully, or a 404 NOT FOUND status if the book doesn't exist.
     */
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

    /**
     * Endpoint to update a book by its ID.
     * Returns the updated book with a 200 OK status if successful, or a 404 NOT FOUND status if the book doesn't exist.
     */
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
