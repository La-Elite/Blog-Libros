package com.spring.app.controller;

import com.spring.domain.Review;
import com.spring.domain.User;
import com.spring.infrastructure.entities.ReviewEntity;
import com.spring.service.BookService;
import com.spring.service.ReviewService;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ReviewEntityController {

    private final ReviewService reviewService;
    private final UserService userService;
    private final BookService bookService;

    public ReviewEntityController(@Qualifier("reviewServiceImpl") ReviewService reviewService,
                                  UserService userService, @Qualifier("bookServiceImpl") BookService bookService) {

        this.reviewService = reviewService;
        this.userService = userService;
        this.bookService = bookService;
    }

    // 1. WebSocket Client (React) send request to app/receive when a user wants to post a book review
    // 2. SpringBoot receives the request and redirect data to service and, with help of repository, store the new book review in the database.
    // 3. Finally, SpringBoot returns the new book review to WebSocket Client (React) to be displayed on the page.
    @MessageMapping("/receive")
    @SendTo("/topic/mensaje")
    public ReviewDTO receiveMessage(@Payload ReviewDTO review) {
        ReviewEntity reviewEntity = new ReviewEntity(
                userService.listUserById(review.user()),
                bookService.listBookById(review.bookIsbn()),
                review.message(),
                LocalDate.now()
        );
        reviewService.saveReview(reviewEntity);
        return review;
    }


    public List<Review> listReviewsByBookIsbn(@PathVariable String bookIsbn) {
        List<ReviewEntity> reviewEntityList = reviewService.listReviewsByBookIsbn(bookIsbn);

        return reviewEntityList.stream().map(reviewEntity -> new Review(reviewEntity.getId(),
                new User(reviewEntity.getUserEntity().getId(), reviewEntity.getUserEntity().getPass()),
                reviewEntity.getMessage(),
                reviewEntity.getDate())).toList();
    }
}
