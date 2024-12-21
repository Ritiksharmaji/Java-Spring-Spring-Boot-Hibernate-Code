package com.apringboot.api.springbootapi.services;

import com.apringboot.api.springbootapi.Dao.BookRepository;
import com.apringboot.api.springbootapi.entities.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// here we can also use the @Component annotataion
@Service
public class Bookservice {

    @Autowired
    // by apply the @Autowired the autometically object will create of
    // BookRepository
    private BookRepository bookRepository;

    // get all books
    public List<Book> getAllBooks() {
        // return list;
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;

    }

    // get single books
    public Book getBookById(int id) {
        Book book = null;
        // here we are handling the exception beacuse if some case 22222222 it will
        // handle
        try {
            book = this.bookRepository.findById(id);

        } catch (Exception e) {
            System.out.println(e);
        }

        return book;
    }

    // to create a book
    public Book ceateBook(Book book) {
        Book result = bookRepository.save(book);
        return result;
    }

    // to delete a book
    public void DeleteBook(int id) {
        bookRepository.deleteById(id);
        // -------here we didn't implement the deleteById() in the BookRepositroy
        // interface but we have
        // implements the CurdRepositroy so in that this all method alredy implemented.

    }

    // to update the data of book
    public void updateBookInfo(Book book, int id) {
        book.setId(id);
        bookRepository.save(book);

    }

}
