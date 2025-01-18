package com.jpa.with.restapi.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book2 {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated ID by the database
    private int id;
    
    private String title;
    
    @OneToOne(cascade=CascadeType.ALL)
    private Author author;
    
    // Default constructor
    public Book2() {
        super();
    }
    
    // Parameterized constructor
    public Book2(int id, String title, Author author) {
        super();
        this.id = id;
        this.title = title;
        this.author = author;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    // toString method for easy logging
    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
    }
}
