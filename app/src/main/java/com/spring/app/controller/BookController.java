package com.spring.app.controller;

import com.spring.domain.Book;
import com.spring.infrastructure.entities.BookEntity;
import com.spring.service.BookService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookController {

    private final BookService bookService;
    private final ReviewEntityController reviewEntityController;

    public BookController(@Qualifier("bookServiceImpl") BookService bookService, ReviewEntityController reviewEntityController) {
        this.bookService = bookService;
        this.reviewEntityController = reviewEntityController;
    }


// WebSocket Client (React) send request to listAllBooks in order to receive all data needed to display in the front-end
    @GetMapping("/book")
    @CrossOrigin
    public List<Book> dataToReact() {
        List<BookEntity> listBookEntity = bookService.listAllBooks();

        return listBookEntity.stream()
                .map(bookEntity ->
                        new Book(bookEntity.getId(),
                                bookEntity.getTitle(),
                                bookEntity.getAuthor(),
                                bookEntity.getImage(),
                                bookEntity.getDescription(),
                                bookEntity.getCategory(),
                                reviewEntityController.listReviewsByBookIsbn(bookEntity.getId())))
                .toList();
    }


}
