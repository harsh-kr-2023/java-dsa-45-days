package com.booktracker.book_catalog.controller;

import com.booktracker.book_catalog.model.Book;
import com.booktracker.book_catalog.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/books/author/{authorName}")
    public ResponseEntity<List<Book>> getBookByAuthor(@PathVariable String authorName) {
        return bookService.getBookByAuthor(authorName);
    }

    @GetMapping("/books/genre/{genre}")
    public ResponseEntity<List<Book>> getBookByGenre(@PathVariable String genre) {
        return bookService.getBookByGenre(genre);
    }

    @GetMapping("/books/title/{title}")
    public ResponseEntity<List<Book>> getBookByTitle(@PathVariable String title) {
        return bookService.getBookByTitle(title);
    }

    @PostMapping("/books")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book bookDetails) {
        return bookService.updateBook(id, bookDetails);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable int id) {
        return bookService.deleteBookById(id);
    }
}