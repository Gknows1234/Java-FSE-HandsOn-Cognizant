package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main application class to initialize the Spring IoC container
 * and test Dependency Injection configurations.
 */
public class LibraryManagementApplication {

    public static void main(String[] args) {
        System.out.println("Starting Library Management Application...");
        
        // Load the Spring context from the XML configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("\n--- Testing Setter Injection ---");
        BookService setterService = (BookService) context.getBean("bookServiceSetter");
        setterService.processBooks();

        System.out.println("\n--- Testing Constructor Injection ---");
        BookService constructorService = (BookService) context.getBean("bookServiceConstructor");
        constructorService.processBooks();
    }
}
