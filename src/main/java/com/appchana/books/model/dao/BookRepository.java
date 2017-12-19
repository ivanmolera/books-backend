package com.appchana.books.model.dao;

import com.appchana.books.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Database Access Object for book table.
 * <p/>
 */
public interface BookRepository extends CrudRepository<Book, Long>
{

    List<Book> findByIsbn(String isbn);

    List<Book> findAll();
}
