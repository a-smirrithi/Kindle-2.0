package com.kindle.library;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAvailable(String available);
    boolean existsByIsbn(String isbn);
    Optional<Book> findByTitle(String title);
}

@Repository
interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}

@Repository
interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {
    List<BorrowedBook> findByReturnDateTimeIsNull();
    List<BorrowedBook> findTop10ByOrderByBorrowDateTimeDesc();
    
    Long countByReturnDateTimeIsNull();
    Long countByUsernameAndReturnDateTimeIsNull(String username);
    
    boolean existsByBookNameAndReturnDateTimeIsNull(String bookName);
    boolean existsByUsernameAndReturnDateTimeIsNull(String username);
    
    @Query("SELECT bb.bookName, COUNT(bb) as borrowCount FROM BorrowedBook bb GROUP BY bb.bookName ORDER BY borrowCount DESC")
    List<Object[]> findMostBorrowedBooks();
}