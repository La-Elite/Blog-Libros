package com.spring.service;

import com.spring.infrastructure.entities.BookEntity;
import com.spring.infrastructure.repository.book.BookManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookManager bookManager;

    public BookServiceImpl(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    @Override
    public BookEntity listBookById(String id) {
        return bookManager.listBookById(id);
    }

    @Override
    public List<BookEntity> listAllBooks() {
        return bookManager.listAllBooks();
    }
}
