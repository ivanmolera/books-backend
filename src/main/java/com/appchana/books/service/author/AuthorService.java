package com.appchana.books.service.author;

import com.appchana.books.dao.model.Author;
import com.appchana.books.exception.ConstraintsViolationException;
import com.appchana.books.exception.EntityNotFoundException;
import com.appchana.books.exception.InvalidIdentifierException;

import java.io.IOException;
import java.util.List;

/**
 * Created by ivanmolera on 05/01/2018.
 */
public interface AuthorService {
    Author find(String id) throws EntityNotFoundException;

    Author create(Author author) throws IOException, ConstraintsViolationException, InvalidIdentifierException;

    void delete(String id) throws EntityNotFoundException;

    List<Author> find(String name, String surname) throws InvalidIdentifierException;
}
