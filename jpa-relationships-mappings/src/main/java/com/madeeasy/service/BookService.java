package com.madeeasy.service;

import com.madeeasy.model.BookEntity;
import com.madeeasy.request.BookRequest;

import java.util.List;


public interface BookService {
    List<BookEntity> getAllBooks();

    BookEntity getBookById(Long id);

    BookEntity addBook(BookEntity bookEntity);

    void deleteBookById(Long id);


    BookEntity updateBookById(Long id, BookRequest bookRequest);

}
