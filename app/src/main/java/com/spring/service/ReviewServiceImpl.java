package com.spring.service;

import com.spring.infrastructure.entities.ReviewEntity;
import com.spring.infrastructure.repository.review.ReviewManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewManager reviewManager;

    public ReviewServiceImpl(ReviewManager reviewManager) {
        this.reviewManager = reviewManager;
    }

    @Override
    public ReviewEntity saveReview(ReviewEntity review) {
        return reviewManager.saveReview(review);
    }

    @Override
    public List<ReviewEntity> listAllReviews() {
        return reviewManager.listAllReviews();
    }


    @Override
    public List<ReviewEntity> listReviewsByBookIsbn(String bookIsbn) {
        return reviewManager.listReviewsByBookIsbn(bookIsbn);
    }
}
