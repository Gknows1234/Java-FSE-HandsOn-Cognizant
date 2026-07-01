package com.library.service;

import com.library.repository.BookRepository;

/**
 * Service logic for handling library operations related to Books.
 */
public class BookService {
    
    private BookRepository bookRepository;

    // Default Constructor
    public BookService() {
    }

    // Constructor Injection Setup (Exercise 7)
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService instance created via Constructor Injection");
    }

    // Setter Injection Setup (Exercises 2 & 7)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookService instance created via Setter Injection");
    }

    public void processBooks() {
        System.out.println("BookService is initiating processing...");
        if (this.bookRepository != null) {
            this.bookRepository.executeQuery();
        } else {
            System.err.println("BookRepository has not been injected properly!");
        }
    }
}
