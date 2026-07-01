package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Spring Boot Library Management Application.
 */
@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {
        System.out.println("Initializing Library Management Spring Boot Application...");
        SpringApplication.run(LibraryManagementApplication.class, args);
    }
}
