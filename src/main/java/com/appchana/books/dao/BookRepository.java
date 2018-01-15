package com.appchana.books.dao;

import com.appchana.books.dao.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Database Access Object for book table.
 */
public interface BookRepository extends MongoRepository<Book, String>
{
    List<Book> findByIsbn10(String isbn10);

    List<Book> findByIsbn13(String isbn13);

    List<Book> findAll();
}
