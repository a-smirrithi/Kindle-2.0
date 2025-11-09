package com.kindle.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LibraryController {

    @Autowired private BookRepository bookRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private BorrowedBookRepository borrowedBookRepository;

    // Health Check
    @GetMapping("/dashboard/health")
    public ResponseEntity<Map<String, Object>> health() {
        Map<String, Object> response = new HashMap<>();
        try {
            // Test database connection
            long bookCount = bookRepository.count();
            response.put("success", true);
            response.put("message", "Backend and database are running");
            response.put("database", "connected");
            response.put("bookCount", bookCount);
            response.put("timestamp", System.currentTimeMillis());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Backend running but database connection failed");
            response.put("database", "disconnected");
            response.put("error", e.getMessage());
            response.put("timestamp", System.currentTimeMillis());
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(response);
        }
    }

    // Dashboard Stats
    @GetMapping("/dashboard/stats")
    public ResponseEntity<Map<String, Object>> getDashboardStats() {
        try {
            Map<String, Object> stats = new HashMap<>();
            stats.put("totalBooks", bookRepository.count());
            stats.put("totalUsers", userRepository.count());
            stats.put("activeBorrows", borrowedBookRepository.countByReturnDateTimeIsNull());
            
            List<BorrowedBook> recentActivity = borrowedBookRepository.findTop10ByOrderByBorrowDateTimeDesc();
            stats.put("recentActivity", recentActivity);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("data", stats);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return createErrorResponse("Error getting stats: " + e.getMessage());
        }
    }

    @GetMapping("/dashboard/most-borrowed")
    public ResponseEntity<Map<String, Object>> getMostBorrowedBooks() {
        try {
            // Query to get book borrow counts
            List<Object[]> results = borrowedBookRepository.findMostBorrowedBooks();
            
            List<Map<String, Object>> mostBorrowed = new ArrayList<>();
            for (Object[] result : results) {
                String bookName = (String) result[0];
                Long borrowCount = (Long) result[1];
                
                Map<String, Object> item = new HashMap<>();
                item.put("bookName", bookName);
                item.put("borrowCount", borrowCount);
                mostBorrowed.add(item);
            }
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("data", mostBorrowed);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return createErrorResponse("Error getting most borrowed books: " + e.getMessage());
        }
    }

    // Book Operations
    @GetMapping("/books")
    public ResponseEntity<Map<String, Object>> getAllBooks() {
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("data", bookRepository.findAll());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return createErrorResponse("Error retrieving books: " + e.getMessage());
        }
    }

    @GetMapping("/books/available")
    public ResponseEntity<Map<String, Object>> getAvailableBooks() {
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("data", bookRepository.findByAvailable("Yes"));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return createErrorResponse("Error retrieving available books: " + e.getMessage());
        }
    }

    @PostMapping("/books")
    public ResponseEntity<Map<String, Object>> addBook(@RequestBody Book book) {
        try {
            if (bookRepository.existsByIsbn(book.getIsbn())) {
                return createErrorResponse("Book with this ISBN already exists");
            }
            
            Book savedBook = bookRepository.save(book);
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("data", savedBook);
            response.put("message", "Book added successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return createErrorResponse("Error adding book: " + e.getMessage());
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Map<String, Object>> deleteBook(@PathVariable Long id) {
        try {
            if (!bookRepository.existsById(id)) {
                return createErrorResponse("Book not found");
            }
            
            // Check if book is currently borrowed
            Optional<Book> bookOpt = bookRepository.findById(id);
            if (bookOpt.isPresent() && borrowedBookRepository.existsByBookNameAndReturnDateTimeIsNull(bookOpt.get().getTitle())) {
                return createErrorResponse("Cannot delete a book that is currently borrowed");
            }
            
            bookRepository.deleteById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "Book deleted successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return createErrorResponse("Error deleting book: " + e.getMessage());
        }
    }

    // User Operations
    @GetMapping("/users")
    public ResponseEntity<Map<String, Object>> getAllUsers() {
        try {
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("data", userRepository.findAll());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return createErrorResponse("Error retrieving users: " + e.getMessage());
        }
    }

    @PostMapping("/users")
    public ResponseEntity<Map<String, Object>> addUser(@RequestBody User user) {
        try {
            if (userRepository.existsByEmail(user.getEmail())) {
                return createErrorResponse("User with this email already exists");
            }
            
            User savedUser = userRepository.save(user);
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("data", savedUser);
            response.put("message", "User added successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return createErrorResponse("Error adding user: " + e.getMessage());
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable Long id) {
        try {
            if (!userRepository.existsById(id)) {
                return createErrorResponse("User not found");
            }
            
            // Check if user has active borrows
            Optional<User> userOpt = userRepository.findById(id);
            if (userOpt.isPresent() && borrowedBookRepository.existsByUsernameAndReturnDateTimeIsNull(userOpt.get().getName())) {
                return createErrorResponse("Cannot delete a user with active borrows");
            }
            
            userRepository.deleteById(id);
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("message", "User deleted successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return createErrorResponse("Error deleting user: " + e.getMessage());
        }
    }

    // Borrow Operations
    @GetMapping("/borrows/active")
    public ResponseEntity<Map<String, Object>> getActiveBorrows() {
        try {
            List<BorrowedBook> borrows = borrowedBookRepository.findByReturnDateTimeIsNull();
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("data", borrows);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return createErrorResponse("Error retrieving active borrows: " + e.getMessage());
        }
    }

    @PostMapping("/borrows")
    public ResponseEntity<Map<String, Object>> borrowBook(@RequestBody Map<String, Object> request) {
        try {
            Long userId = Long.valueOf(request.get("userId").toString());
            Long bookId = Long.valueOf(request.get("bookId").toString());
            String borrowDate = request.get("borrowDate").toString();
            String dueDate = request.get("dueDate").toString();
            
            // Optional time fields
            String borrowTime = request.containsKey("borrowTime") ? request.get("borrowTime").toString() : "00:00";
            String dueTime = request.containsKey("dueTime") ? request.get("dueTime").toString() : "23:59";
            
            // Validate user and book
            Optional<User> userOpt = userRepository.findById(userId);
            Optional<Book> bookOpt = bookRepository.findById(bookId);
            
            if (!userOpt.isPresent()) {
                return createErrorResponse("User not found");
            }
            if (!bookOpt.isPresent()) {
                return createErrorResponse("Book not found");
            }
            
            Book book = bookOpt.get();
            if (!"Yes".equals(book.getAvailable())) {
                return createErrorResponse("Book is not available for borrowing");
            }
            
            // Check borrow limit (5 books per user)
            User user = userOpt.get();
            Long activeBorrows = borrowedBookRepository.countByUsernameAndReturnDateTimeIsNull(user.getName());
            if (activeBorrows >= 5) {
                return createErrorResponse("User has reached the maximum borrow limit (5 books)");
            }
            
            // Create borrow record with simplified datetime structure
            BorrowedBook borrowedBook = new BorrowedBook();
            borrowedBook.setUsername(user.getName());
            borrowedBook.setBookName(book.getTitle());
            borrowedBook.setBorrowDateTime(LocalDateTime.of(LocalDate.parse(borrowDate), LocalTime.parse(borrowTime)));
            borrowedBook.setDueDateTime(LocalDateTime.of(LocalDate.parse(dueDate), LocalTime.parse(dueTime)));
            
            BorrowedBook savedBorrow = borrowedBookRepository.save(borrowedBook);
            
            // Update book availability
            book.setAvailable("No");
            bookRepository.save(book);
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("data", savedBorrow);
            response.put("message", "Book borrowed successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            return createErrorResponse("Error borrowing book: " + e.getMessage());
        }
    }

    @PutMapping("/borrows/{id}/return")
    public ResponseEntity<Map<String, Object>> returnBook(@PathVariable Long id, @RequestBody(required = false) Map<String, Object> request) {
        try {
            Optional<BorrowedBook> borrowOpt = borrowedBookRepository.findById(id);
            if (!borrowOpt.isPresent()) {
                return createErrorResponse("Borrow record not found");
            }
            
            BorrowedBook borrow = borrowOpt.get();
            if (borrow.getReturnDateTime() != null) {
                return createErrorResponse("Book has already been returned");
            }
            
            // Set return datetime
            LocalDateTime returnDateTime = LocalDateTime.now();
            
            if (request != null) {
                if (request.containsKey("returnDate") && request.containsKey("returnTime")) {
                    LocalDate returnDate = LocalDate.parse(request.get("returnDate").toString());
                    LocalTime returnTime = LocalTime.parse(request.get("returnTime").toString());
                    returnDateTime = LocalDateTime.of(returnDate, returnTime);
                }
            }
            
            borrow.setReturnDateTime(returnDateTime);
            borrowedBookRepository.save(borrow);
            
            // Update book availability - find book by title
            Optional<Book> bookOpt = bookRepository.findByTitle(borrow.getBookName());
            if (bookOpt.isPresent()) {
                Book book = bookOpt.get();
                book.setAvailable("Yes");
                bookRepository.save(book);
            }
            
            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("data", borrow);
            response.put("message", "Book returned successfully");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return createErrorResponse("Error returning book: " + e.getMessage());
        }
    }

    // Helper method to create error responses
    private ResponseEntity<Map<String, Object>> createErrorResponse(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("success", false);
        response.put("message", message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}