package com.SpringBoot4_JPA.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.SpringBoot4_JPA.entities.Book;
import java.util.ArrayList;
import java.util.List;

@RestController
public class BookAPIs_2_RestController2 {

    // Single Book
    @GetMapping("/book")
    public Book getBook() {
        Book book = new Book();
        book.setId(111);
        book.setTitle("Java Programming");
        book.setAuthor("Raja Singh");

        return book;
    }

    // List of Books
    @GetMapping("/books")
    public List<Book> getBooks() {
        // Create a list to hold books
        List<Book> books = new ArrayList<>();

        // Create book objects
        Book book1 = new Book();
        book1.setId(112);
        book1.setTitle("Python Programming");
        book1.setAuthor("Python Sir");

        Book book2 = new Book();
        book2.setId(113);
        book2.setTitle("JavaScript Programming");
        book2.setAuthor("JavaScript Sir");

        Book book3 = new Book();
        book3.setId(114);
        book3.setTitle("React JS Programming");
        book3.setAuthor("React Sir");

        // Add books to the list
        books.add(book1);
        books.add(book2);
        books.add(book3);

        return books;
    }
}
