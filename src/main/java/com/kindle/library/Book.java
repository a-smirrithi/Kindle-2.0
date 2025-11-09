package com.kindle.library;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String title;
    
    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String author;
    
    @NotBlank
    @Size(max = 20)
    @Column(unique = true, nullable = false)
    private String isbn;
    
    @NotBlank
    @Size(max = 100)
    @Column(nullable = false)
    private String genre;
    
    @Column(nullable = false)
    private String available = "Yes";

    // Constructors
    public Book() {}
    
    public Book(String title, String author, String isbn, String genre) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.available = "Yes";
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getAvailable() { return available; }
    public void setAvailable(String available) { this.available = available; }
    
    // Helper methods for boolean operations
    public boolean isAvailable() { return "Yes".equals(available); }
    public void setAvailable(boolean available) { this.available = available ? "Yes" : "No"; }
}