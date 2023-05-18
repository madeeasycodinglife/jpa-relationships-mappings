package com.madeeasy.service.impl;


import com.madeeasy.error.ResourceNotFoundException;
import com.madeeasy.model.BookEntity;
import com.madeeasy.model.CategoryEntity;
import com.madeeasy.repository.AuthorRepository;
import com.madeeasy.repository.BookRepository;
import com.madeeasy.repository.CategoryRepository;
import com.madeeasy.request.BookRequest;
import com.madeeasy.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<BookEntity> getAllBooks() {
        System.out.println(bookRepository.findAll());
        return bookRepository.findAll();
    }

    @Override
    public BookEntity getBookById(Long id) {
        Optional<BookEntity> findById = bookRepository.findById(id);
        if (findById.isPresent()) {
            return findById.get();
        } else {
            throw new ResourceNotFoundException("Not Found :(");
        }
    }

    @Override
    public BookEntity addBook(BookEntity bookEntity) {
        authorRepository.save(bookEntity.getAuthorEntity());
        List<CategoryEntity> categorieEntityList = bookEntity.getCategoryEntity();
        List<CategoryEntity> categoryEntityList = bookEntity.getCategoryEntity();
        if (categoryEntityList != null) {
            for (CategoryEntity categoryEntity : categoryEntityList) {
                categoryRepository.save(categoryEntity);
            }
        }
        return bookRepository.save(bookEntity);
    }

    @Override
    public void deleteBookById(Long id) {
        Optional<BookEntity> findById = bookRepository.findById(id);
        if (findById.isPresent()) {
            bookRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Not Found :(");
        }
    }


    @Override
    public BookEntity updateBookById(Long id, BookRequest bookRequest) {
        Optional<BookEntity> findById = bookRepository.findById(id);
        if (findById.isPresent()) {

            BookEntity bookEntity = findById.get();

            if (bookRequest.getAuthorEntity() != null) {
                bookEntity.setAuthorEntity(bookRequest.getAuthorEntity());
            }
            if (bookRequest.getCategorieEntity() != null) {
                bookEntity.setCategoryEntity(bookRequest.getCategorieEntity());
            }
            authorRepository.save(bookEntity.getAuthorEntity());
            List<CategoryEntity> categoryEntityList = bookEntity.getCategoryEntity();
            for (CategoryEntity categoryEntity : categoryEntityList) {
                categoryRepository.save(categoryEntity);
            }
            return bookRepository.save(bookEntity);
        } else {
            throw new ResourceNotFoundException("Not found :(");
        }
    }
}
