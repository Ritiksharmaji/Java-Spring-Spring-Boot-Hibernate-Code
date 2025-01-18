package com.jpa.with.restapi.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jpa.with.restapi.dao.BookRepository_2;
import com.jpa.with.restapi.entities.Book;
import com.jpa.with.restapi.entities.Book2;

import java.util.List;


@Service
public class BookService_2 {
    @Autowired
    private BookRepository_2 bookRepository;

    public List<Book2> getAllBooks() {
        return (List<Book2>) this.bookRepository.findAll();
    }

    public Book2 getBookById(int id) {
        return this.bookRepository.findById(id);
    }

    public Book2 addBook(Book2 book) {
        return this.bookRepository.save(book);
    }

    public boolean removeBook(int id) {
        if (this.bookRepository.existsById(id)) {
            this.bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

//    public Book2 updateBook(int id, Book2 updatedBook) {
//        return this.bookRepository.findById(id).map(existingBook -> {
//            existingBook.setTitle(updatedBook.getTitle());
//            existingBook.setAuthor(updatedBook.getAuthor());
//            return this.bookRepository.save(existingBook);
//        }).orElse(null);
//    }
}
