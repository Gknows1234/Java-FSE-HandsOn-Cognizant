package com.library.repository;

import com.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA Repository for Book entity.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Custom query methods can be defined here if needed
}
