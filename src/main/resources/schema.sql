-- Kindle 2.0 Library Management System - Simplified Database Schema

CREATE DATABASE IF NOT EXISTS kindle_library;
USE kindle_library;

-- Books table
CREATE TABLE IF NOT EXISTS books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) NOT NULL UNIQUE,
    genre VARCHAR(100) NOT NULL,
    available VARCHAR(3) NOT NULL DEFAULT 'Yes'
);

-- Users table
CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL
);

-- Borrowed books table  
CREATE TABLE IF NOT EXISTS borrowed_books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    book_name VARCHAR(255) NOT NULL,
    username VARCHAR(255) NOT NULL,
    borrow_datetime DATETIME NOT NULL,
    due_datetime DATETIME NOT NULL,
    return_datetime DATETIME DEFAULT NULL
);

-- Create indexes for performance
CREATE INDEX idx_books_available ON books(available);
CREATE INDEX idx_books_isbn ON books(isbn);
CREATE INDEX idx_users_username ON users(username);
CREATE INDEX idx_users_email ON users(email);
CREATE INDEX idx_borrowed_books_book_name ON borrowed_books(book_name);
CREATE INDEX idx_borrowed_books_username ON borrowed_books(username);
CREATE INDEX idx_borrowed_books_return_datetime ON borrowed_books(return_datetime);
CREATE INDEX idx_borrowed_books_user_id ON borrowed_books(user_id);
CREATE INDEX idx_borrowed_books_return_date ON borrowed_books(return_date);