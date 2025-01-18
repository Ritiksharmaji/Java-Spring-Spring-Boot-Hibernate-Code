package com.jpa.with.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jpa.with.restapi.entities.Book3;
import com.jpa.with.restapi.service.BookService_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v3") // Optional base path for better organization
public class BookAPIs_Controller_3 {
    @Autowired
    private BookService_3 bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book3>> getBooks() {
        List<Book3> books = this.bookService.getAllBooks();
        
        return books.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(books);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book3> getBook(@PathVariable int id) {
    	Book3 book = this.bookService.getBookById(id);
        return book == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(book);
    }

    @PostMapping("/books")
    public ResponseEntity<Book3> addBook(@RequestBody Book3 book) {
    	Book3 addedBook = this.bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);
    }

//    @PutMapping("/book/{id}")
//    public ResponseEntity<Book2> updateBook(@PathVariable int id, @RequestBody Book2 updatedBook) {
//        Book2 book = this.bookService.updateBook(id, updatedBook);
//        return book == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(book);
//    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        return this.bookService.removeBook(id) ? ResponseEntity.ok().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
