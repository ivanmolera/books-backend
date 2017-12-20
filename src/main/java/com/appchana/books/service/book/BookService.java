package com.appchana.books.service.book;

import com.appchana.books.model.Book;
import com.appchana.books.exception.EntityNotFoundException;

import java.util.List;


public interface BookService
{

    Book find(Long bookId) throws EntityNotFoundException, EntityNotFoundException;

    List<Book> find(String isbn10);

}
