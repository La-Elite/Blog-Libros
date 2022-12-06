package com.spring.infrastructure.repository.review;

import com.spring.infrastructure.entities.BookEntity;
import com.spring.infrastructure.entities.ReviewEntity;
import com.spring.service.BookService;
import com.spring.service.ReviewService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewManager implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final BookService bookService;

    public ReviewManager(ReviewRepository reviewRepository, @Qualifier("bookServiceImpl") BookService bookService) {
        this.reviewRepository = reviewRepository;
        this.bookService = bookService;
    }

    @Override
    public ReviewEntity saveReview(ReviewEntity review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<ReviewEntity> listAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public List<ReviewEntity> listReviewsByBookIsbn(String bookIsbn) {
        BookEntity bookEntity = bookService.listBookById(bookIsbn);
        return reviewRepository.findAllByBook(bookEntity);
    }
}

