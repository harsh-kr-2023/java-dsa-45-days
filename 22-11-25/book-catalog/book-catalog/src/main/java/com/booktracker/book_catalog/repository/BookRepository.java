package com.booktracker.book_catalog.repository;

import com.booktracker.book_catalog.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByAuthorContainingIgnoreCase(String authorName);

    List<Book> findByGenreContainingIgnoreCase(String genre);

    List<Book> findByNameContainingIgnoreCase(String title);
}
