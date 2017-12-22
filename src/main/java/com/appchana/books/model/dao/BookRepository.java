package com.appchana.books.model.dao;

import com.appchana.books.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Database Access Object for book table.
 */
public interface BookRepository extends CrudRepository<Book, Long>
{
    List<Book> findByIsbn10(String isbn10);

    List<Book> findByIsbn13(String isbn13);

    List<Book> findAll();
}
