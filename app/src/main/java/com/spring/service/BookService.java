package com.spring.service;

import com.spring.infrastructure.entities.BookEntity;

import java.util.List;

public interface BookService {

    BookEntity listBookById(String id);

    List<BookEntity> listAllBooks();
}
