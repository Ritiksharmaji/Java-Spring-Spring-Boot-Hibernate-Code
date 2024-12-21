package com.apringboot.api.springbootapi.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.apringboot.api.springbootapi.entities.Author;
import com.apringboot.api.springbootapi.entities.Book;
import com.apringboot.api.springbootapi.services.Bookservice;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

//@Controller
// we can use the @RestController for Spring-boot rest API inplace of
// @Controller then we don't need to give the @RestposeBody
// annotaion
@RestController
public class BookController {

    @Autowired
    private Bookservice bookservice;

    // @RequestMapping(value = "/books", method = RequestMethod.GET)
    // we can use the @GetMapping() method inplace of above code and here Get define
    // the Get method
    // @ResponseBody

    @GetMapping("/string")
    public String getString() {

        Book book = new Book();
        book.setId(100);
        book.setTitle("java by RItik");
        // book.setAuthor("Ritik sharma");

        return "this url for getting the books details by api controller with @GetMapping method";
    }

    // here we are sending the book details and by-default spring-book convert it
    // into json formate
    @GetMapping("/books")
    public Book getBooks() {

        Book book = new Book();
        book.setId(100);
        book.setTitle("java by Ritik");
        // book.setAuthor("Ritik sharma");

        return book;
    }

    // for bookService of single book by restAPi
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> bookservice(@PathVariable("id") int id) {

        // Bookservice service = new Bookservice();
        Book book = bookservice.getBookById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // return bookservice.getBookById(id);
        return ResponseEntity.of(Optional.of(book));
    }

    // -------------------- ResponseEntity is used to send the data with
    // status-----------------------
    @GetMapping("/bookSservice")
    public ResponseEntity<List<Book>> bookSservice() {

        List<Book> bookList = bookservice.getAllBooks();
        if (bookList.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.of(Optional.of(bookList));

    }

    // ---------------------------POST METHOD
    // --------------------------------------------------------
    // request url method(Handler) for create a book

    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody Book b) {
        // to get the Book which is created now

        Book book = null;

        try {

            book = this.bookservice.ceateBook(b);
            
            // return ResponseEntity.status(HttpStatus.CREATED).build();
            if (book == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            // return ResponseEntity.of(Optional.of(book));
            return ResponseEntity.status(HttpStatus.CREATED).build();

        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    // to get the createdBook id
    @PostMapping("/book/id")
    public int addBookId(@RequestBody Book b) {
        // TODO: process POST request
        // to get the Book which is created now
        Book book = this.bookservice.ceateBook(b);

        return book.getId();
    }

    // ------------------------------DELETE-------------------------------------------------
    // delete a book handler it will
    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable("id") int id) {

        this.bookservice.DeleteBook(id);
        return "book deleted with id:" + id;

    }

    // -------------------Update
    // Book----------------------------------------------------
    @PutMapping("books/book/{id}")
    public Book putMethodName(@PathVariable int id, @RequestBody Book entity) {
        // TODO: process PUT request
        this.bookservice.updateBookInfo(entity, id);

        return entity;
    }

}
