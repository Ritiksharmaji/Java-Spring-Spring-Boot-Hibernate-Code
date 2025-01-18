package com.jpa.with.restapi.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jpa.with.restapi.dao.BookRepository_3;
import com.jpa.with.restapi.entities.Book3;

import java.util.List;


@Service
public class BookService_3 {
    @Autowired
    private BookRepository_3 bookRepository;

    public List<Book3> getAllBooks() {
        return (List<Book3>) this.bookRepository.findAll();
    }

    public Book3 getBookById(int id) {
        return this.bookRepository.findById(id);
    }

    public Book3 addBook(Book3 book) {
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
