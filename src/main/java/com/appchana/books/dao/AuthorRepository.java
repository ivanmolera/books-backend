package com.appchana.books.dao;

import com.appchana.books.dao.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Database Access Object for authors table.
 */
public interface AuthorRepository extends CrudRepository<Author, String>
{
    List<Author> findByNameAndSurname(String name, String surname);

    List<Author> findAll();
}
