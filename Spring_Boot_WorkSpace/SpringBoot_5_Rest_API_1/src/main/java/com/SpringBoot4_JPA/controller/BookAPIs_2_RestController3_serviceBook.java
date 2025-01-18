package com.SpringBoot4_JPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot4_JPA.entities.Book;
import com.SpringBoot4_JPA.service.BookService_1;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookAPIs_2_RestController3_serviceBook {

    @Autowired
    private BookService_1 bookService;

// ------------------------- this is for get request ---------------------------------------------------    
    // Endpoint to get all dynamic books
    @GetMapping("/third/books")
    public List<Book> getBooks() {
        return this.bookService.getAllBooks();
    }

    // Endpoint to get a dynamic book by ID
    @GetMapping("/third/book/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return this.bookService.getBookById(id);
    }

    // Endpoint to get all static books
    @GetMapping("/third/static/books")
    public List<Book> getStaticBooks() {
        return BookService_1.getStaticBooks();
    }

    // Endpoint to get all books (dynamic + static)
    @GetMapping("/third/All/books")
    public List<Book> getAllBooks() {
        List<Book> staticBooks = BookService_1.getStaticBooks(); // Get static books
        List<Book> dynamicBooks = this.bookService.getAllBooks(); // Get dynamic books

        // Combine static and dynamic books into one list
        List<Book> allBooks = new ArrayList<>();
        allBooks.addAll(staticBooks);
        allBooks.addAll(dynamicBooks);

        return allBooks; // Return the combined list
    }
    
// ----------------------- this is for post request -----------------------------------------------------
   
    // Endpoint to get all dynamic books
    @PostMapping("/third/books")
    public Book getBooks( @RequestBody Book book) {
		
    	Book book2 = this.bookService.addBook(book);
    	return book2;
        
    }
    
// -----------------------this is for delete method ------------------------------------------------------------
    
    // Endpoint to get a dynamic book by ID
    @DeleteMapping("/third/book/{id}")
    public boolean deleteBook(@PathVariable("id") int id) {
        return this.bookService.removeBook(id);
    }
    
    
 // ----------------------- PUT Request ------------------------------------------------------

    // Endpoint to update a dynamic book by ID
    @PutMapping("/third/book/{id}")
    public Book updateBook(@PathVariable("id") int id, @RequestBody Book updatedBook) {
        Book book = this.bookService.updateBook(id, updatedBook);
        if (book != null) {
            return book; // Return the updated book
        } else {
            throw new RuntimeException("Book with ID " + id + " not found!"); // Handle book not found
        }
    }
    
}
