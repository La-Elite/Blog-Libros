package com.spring.infrastructure.repository.review;

import com.spring.infrastructure.entities.BookEntity;
import com.spring.infrastructure.entities.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository  extends JpaRepository<ReviewEntity,Integer> {
    List<ReviewEntity> findAllByBook(BookEntity book);
}
