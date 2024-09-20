package org.management.lms.dao;



import org.management.lms.model.Book;
import org.management.lms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer>{


   // Optional<User> findById(Long bookId);
}
