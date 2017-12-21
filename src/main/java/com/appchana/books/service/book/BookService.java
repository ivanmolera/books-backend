package com.appchana.books.service.book;

import com.appchana.books.exception.ConstraintsViolationException;
import com.appchana.books.model.Book;
import com.appchana.books.exception.EntityNotFoundException;

import java.io.IOException;
import java.util.List;


public interface BookService
{

    Book find(Long bookId) throws EntityNotFoundException;

    Book create(Book book) throws IOException, ConstraintsViolationException;

    void delete(Long bookId) throws EntityNotFoundException;

    List<Book> find(String isbn10);

}
