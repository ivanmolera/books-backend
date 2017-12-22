package com.appchana.books.dao;

import com.appchana.books.dao.model.Book;
import com.appchana.books.dao.model.UserBook;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Database Access Object for userbook table.
 */
public interface UserBookRepository extends CrudRepository<UserBook, Long>
{
    List<UserBook> findByUserId(Long userId);

    List<UserBook> findAll();
}
