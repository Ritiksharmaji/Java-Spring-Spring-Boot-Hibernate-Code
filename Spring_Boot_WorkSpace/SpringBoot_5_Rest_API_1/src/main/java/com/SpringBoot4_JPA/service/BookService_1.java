package com.SpringBoot4_JPA.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.SpringBoot4_JPA.entities.Book;

@Service
public class BookService_1 {

    // Instance-level list to hold books
    private List<Book> books;

    // Static list to hold static book data
    private static List<Book> static_list = new ArrayList<>();

    // Static block to initialize static book data
    static {
        static_list.add(new Book(150, "C Programming", "C Sir"));
        static_list.add(new Book(151, "C++ Programming", "C++ Sir"));
        static_list.add(new Book(152, "C# Programming", "C# Sir"));
    }

    /**
     * Constructor to initialize the book list with some default data.
     * Also demonstrates different ways to add books (using setters and parameterized constructor).
     */
    public BookService_1() {
        books = new ArrayList<>();

        // Adding books using setter methods
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

        books.add(book1);
        books.add(book2);
        books.add(book3);

        // Adding books using the parameterized constructor
        books.add(new Book(115, "HTML Programming", "HTML Sir"));
        books.add(new Book(116, "CSS Programming", "CSS Sir"));
        books.add(new Book(117, "Next JS Programming", "Next Sir"));
        books.add(new Book(118, "Spring Boot Programming", "Spring Sir"));
    }

    /**
     * Method to retrieve all books.
     * @return List of all books.
     */
    public List<Book> getAllBooks() {
        return books;
    }

    /**
     * Method to retrieve a single book by its ID.
     * @param id ID of the book.
     * @return Book if found, otherwise null.
     */
    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /**
     * Method to add a new book to the list.
     * @param book Book object to be added.
     */
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    /**
     * Method to remove a book by its ID.
     * @param id ID of the book to remove.
     * @return true if the book was removed, false otherwise.
     */
    public boolean removeBook(int id) {
        return books.removeIf(book -> book.getId() == id);
    }
    
    /**
     * Method to update a book by its ID.
     * @param id ID of the book to update.
     * @param updatedBook Book object containing updated data.
     * @return Updated book if found and updated, otherwise null.
     */
    public Book updateBook(int id, Book updatedBook) {
        for (Book book : books) {
            if (book.getId() == id) {
                // Update book details
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                return book; // Return the updated book
            }
        }
        return null; // Return null if no book with the given ID is found
    }


    /**
     * Method to retrieve static books (optional).
     * @return Static list of books.
     */
    public static List<Book> getStaticBooks() {
        return static_list;
    }
}
