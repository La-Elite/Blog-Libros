package com.spring.service;

import com.spring.infrastructure.entities.ReviewEntity;

import java.util.List;

public interface ReviewService {

    ReviewEntity saveReview(ReviewEntity review);
    List<ReviewEntity> listAllReviews();
    List<ReviewEntity> listReviewsByBookIsbn(String bookIsbn);
}
