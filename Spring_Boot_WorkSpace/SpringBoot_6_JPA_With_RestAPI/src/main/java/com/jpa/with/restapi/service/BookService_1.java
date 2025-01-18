package com.jpa.with.restapi.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.with.restapi.dao.BookRepository_1;
import com.jpa.with.restapi.entities.Book;

import java.util.List;
import java.util.Optional;

@Service
public class BookService_1 {
    @Autowired
    private BookRepository_1 bookRepository;

    public List<Book> getAllBooks() {
        return (List<Book>) this.bookRepository.findAll();
    }

    public Book getBookById(int id) {
        Book book = this.bookRepository.findById(id);
        return book;
    }

  
    public Book addBook(Book book) {
        return this.bookRepository.save(book); // Save the book using JPA repository
    }

    public boolean removeBook(int id) {
    	Book book = this.bookRepository.findById(id);
        if (book != null) {
            this.bookRepository.deleteById(id); // Delete the book by ID
            return true;
        }
        return false; // Return false if the book wasn't found
    }


    public Book updateBook(int id, Book updatedBook) {
        Book existingBook = this.bookRepository.findById(id);
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        return this.bookRepository.save(existingBook); // Save the updated book
    }

  
}
