package com.kindle.library;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "borrowed_books")
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "book_name", nullable = false)
    private String bookName;
    
    @Column(name = "username", nullable = false)
    private String username;
    
    @Column(name = "borrow_datetime", nullable = false)
    private LocalDateTime borrowDateTime;
    
    @Column(name = "due_datetime", nullable = false)
    private LocalDateTime dueDateTime;
    
    @Column(name = "return_datetime")
    private LocalDateTime returnDateTime;

    // Constructors
    public BorrowedBook() {}
    
    public BorrowedBook(String bookName, String username, LocalDateTime borrowDateTime, LocalDateTime dueDateTime) {
        this.bookName = bookName;
        this.username = username;
        this.borrowDateTime = borrowDateTime;
        this.dueDateTime = dueDateTime;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getBookName() { return bookName; }
    public void setBookName(String bookName) { this.bookName = bookName; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public LocalDateTime getBorrowDateTime() { return borrowDateTime; }
    public void setBorrowDateTime(LocalDateTime borrowDateTime) { this.borrowDateTime = borrowDateTime; }

    public LocalDateTime getDueDateTime() { return dueDateTime; }
    public void setDueDateTime(LocalDateTime dueDateTime) { this.dueDateTime = dueDateTime; }

    public LocalDateTime getReturnDateTime() { return returnDateTime; }
    public void setReturnDateTime(LocalDateTime returnDateTime) { this.returnDateTime = returnDateTime; }
    
    // Helper methods for formatted display
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public String getFormattedBorrowDateTime() {
        return borrowDateTime != null ? borrowDateTime.format(DATETIME_FORMATTER) : "Not Set";
    }
    
    public String getFormattedDueDateTime() {
        return dueDateTime != null ? dueDateTime.format(DATETIME_FORMATTER) : "Not Set";
    }
    
    public String getFormattedReturnDateTime() {
        return returnDateTime != null ? returnDateTime.format(DATETIME_FORMATTER) : "Not Returned";
    }
    
    // Compatibility methods for backward compatibility (if needed)
    public String getBorrowDate() { 
        return borrowDateTime != null ? borrowDateTime.toLocalDate().toString() : null; 
    }
    
    public String getReturnDate() { 
        return returnDateTime != null ? returnDateTime.toLocalDate().toString() : null; 
    }
}