package com.appchana.books.service.book;

import com.appchana.books.dto.BookDTO;
import com.appchana.books.exception.ConstraintsViolationException;
import com.appchana.books.exception.InvalidIdentifierException;
import com.appchana.books.dao.model.Book;
import com.appchana.books.exception.EntityNotFoundException;

import java.io.IOException;
import java.util.List;


public interface BookService
{

    Book find(String id) throws EntityNotFoundException;

    Book create(Book book) throws IOException, ConstraintsViolationException, InvalidIdentifierException;

    List<BookDTO> getUserBooks(List<String> booksList) throws EntityNotFoundException;

    void delete(String id) throws EntityNotFoundException;

    List<Book> findByISBN(String isbn) throws InvalidIdentifierException;

}
