-- MySQL Queries for Kindle 2.0 Library Management System
-- Connect: mysql -u root -p

USE kindle_library;

-- Show all tables
SHOW TABLES;

-- View all books
SELECT id, title, author, isbn, genre, available FROM books;

-- View all users  
SELECT id, name, email, phone FROM users;

-- View all borrowed books
SELECT * FROM borrowed_books ORDER BY borrow_date DESC;

-- View borrowed books with book and user details
SELECT 
    bb.id as borrow_id,
    b.title as book_title,
    b.author as book_author,
    u.name as user_name,
    u.email as user_email,
    bb.borrow_date,
    bb.borrow_time,
    bb.due_date,
    bb.due_time,
    bb.return_date,
    bb.return_time,
    CASE 
        WHEN bb.return_date IS NULL THEN 'BORROWED'
        ELSE 'RETURNED'
    END as status
FROM borrowed_books bb
JOIN books b ON bb.book_id = b.id  
JOIN users u ON bb.user_id = u.id
ORDER BY bb.borrow_date DESC;

-- Books due today
SELECT 
    b.title,
    u.name,
    bb.due_date,
    bb.due_time
FROM borrowed_books bb
JOIN books b ON bb.book_id = b.id  
JOIN users u ON bb.user_id = u.id
WHERE bb.return_date IS NULL 
AND bb.due_date = CURDATE();

-- Most borrowed books
SELECT 
    b.title,
    b.author,
    COUNT(bb.id) as borrow_count
FROM books b
JOIN borrowed_books bb ON b.id = bb.book_id
GROUP BY b.id, b.title, b.author
ORDER BY borrow_count DESC;

-- Currently borrowed books
SELECT 
    b.title,
    u.name,
    bb.borrow_date,
    bb.due_date,
    DATEDIFF(bb.due_date, CURDATE()) as days_until_due
FROM borrowed_books bb
JOIN books b ON bb.book_id = b.id  
JOIN users u ON bb.user_id = u.id
WHERE bb.return_date IS NULL
ORDER BY bb.due_date ASC;