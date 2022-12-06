package com.spring.infrastructure.repository.book;

import com.spring.infrastructure.entities.BookEntity;
import com.spring.service.BookService;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookManager implements BookService {

    private final BookRepository bookRepository;

    public BookManager(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity listBookById(String id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<BookEntity> listAllBooks() {
        return bookRepository.findAll();
    }
}
