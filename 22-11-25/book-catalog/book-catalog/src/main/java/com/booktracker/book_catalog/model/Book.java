package com.booktracker.book_catalog.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.Year;

@Data
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Book name is required")
    @Size(min = 1, max = 255, message = "Book name must be between 1 and 255 characters")
    private String name;

    @NotBlank(message = "Author name is required")
    @Size(min = 1, max = 255, message = "Author name must be between 1 and 255 characters")
    private String author;

    @NotBlank(message = "Genre is required")
    private String genre;

    @Min(value = 1000, message = "Publication year must be after 1000")
    @Max(value = 2030, message = "Publication year must be realistic")
    private Integer publicationYear;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Reading status is required")
    private ReadingStatus readingStatus;

    @Min(1)
    @Max(5)
    private Integer rating;

    @Size(max = 1000, message = "Review must not exceed 1000 characters")
    private String review;

    // Enum definition inside the class
    public enum ReadingStatus {
        READ, UNREAD, READING
    }
}