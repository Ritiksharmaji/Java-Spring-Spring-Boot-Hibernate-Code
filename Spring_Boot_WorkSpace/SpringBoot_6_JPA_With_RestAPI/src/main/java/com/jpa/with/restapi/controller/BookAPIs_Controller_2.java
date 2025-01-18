package com.jpa.with.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jpa.with.restapi.entities.Book;
import com.jpa.with.restapi.entities.Book2;
import com.jpa.with.restapi.service.BookService_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v2") // Optional base path for better organization
public class BookAPIs_Controller_2 {
    @Autowired
    private BookService_2 bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book2>> getBooks() {
        List<Book2> books = this.bookService.getAllBooks();
        return books.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(books);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book2> getBook(@PathVariable int id) {
        Book2 book = this.bookService.getBookById(id);
        return book == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).build() : ResponseEntity.ok(book);
    }

    @PostMapping("/books")
    public ResponseEntity<Book2> addBook(@RequestBody Book2 book) {
        Book2 addedBook = this.bookService.addBook(book);
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
