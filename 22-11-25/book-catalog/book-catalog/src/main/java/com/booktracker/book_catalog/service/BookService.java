package com.booktracker.book_catalog.service;

import com.booktracker.book_catalog.model.Book;
import com.booktracker.book_catalog.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public ResponseEntity<List<Book>> getAllBooks() {
        try {
            return new ResponseEntity<>(new ArrayList<>(bookRepository.findAll()),HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Book> getBookById(int id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<String> addBook(Book book) {
        try {
            bookRepository.save(book);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>("Failed", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<Book>> getBookByAuthor(String authorName) {
        try {
            List<Book> books = bookRepository.findByAuthorContainingIgnoreCase(authorName);
            if (books.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(books);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<List<Book>> getBookByGenre(String genre) {
        try {
            List<Book> books = bookRepository.findByGenreContainingIgnoreCase(genre);
            if (books.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(books);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<List<Book>> getBookByTitle(String title) {
        try {
            List<Book> books = bookRepository.findByNameContainingIgnoreCase(title);
            if (books.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(books);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<String> deleteBookById(int id) {
        try {
            if (bookRepository.existsById(id)) {
                bookRepository.deleteById(id);
                return ResponseEntity.ok("Book with ID " + id + " deleted successfully");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Book with ID " + id + " not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting book: " + e.getMessage());
        }
    }

    public ResponseEntity<Book> updateBook(int id, Book bookDetails) {
        try {
            // 1. Check if book exists
            Optional<Book> existingBookOpt = bookRepository.findById(id);

            if (existingBookOpt.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            // 2. Get the existing book
            Book existingBook = existingBookOpt.get();

            // 3. Update only the provided fields (partial update)
            if (bookDetails.getName() != null) {
                existingBook.setName(bookDetails.getName());
            }
            if (bookDetails.getAuthor() != null) {
                existingBook.setAuthor(bookDetails.getAuthor());
            }
            if (bookDetails.getGenre() != null) {
                existingBook.setGenre(bookDetails.getGenre());
            }
            if (bookDetails.getPublicationYear() != null) {
                existingBook.setPublicationYear(bookDetails.getPublicationYear());
            }
            if (bookDetails.getReadingStatus() != null) {
                existingBook.setReadingStatus(bookDetails.getReadingStatus());
            }
            if (bookDetails.getRating() != null) {
                existingBook.setRating(bookDetails.getRating());
            }
            if (bookDetails.getReview() != null) {
                existingBook.setReview(bookDetails.getReview());
            }

            // 4. Save the updated book
            Book updatedBook = bookRepository.save(existingBook);

            // 5. Return the updated book
            return ResponseEntity.ok(updatedBook);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
