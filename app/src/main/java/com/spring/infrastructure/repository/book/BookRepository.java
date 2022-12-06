package com.spring.infrastructure.repository.book;

import com.spring.infrastructure.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<BookEntity,String> {
}
