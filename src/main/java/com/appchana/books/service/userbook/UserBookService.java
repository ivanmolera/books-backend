package com.appchana.books.service.userbook;

import com.appchana.books.dao.model.UserBook;
import com.appchana.books.exception.ConstraintsViolationException;
import com.appchana.books.exception.EntityNotFoundException;
import com.appchana.books.exception.InvalidIdentifierException;
import com.appchana.books.dao.model.Book;

import java.io.IOException;
import java.util.List;


public interface UserBookService
{

    UserBook find(Long userBookId) throws EntityNotFoundException;

    UserBook create(UserBook userBook) throws IOException, ConstraintsViolationException, InvalidIdentifierException;

    void delete(Long userBookId) throws EntityNotFoundException;

    List<UserBook> findUserBooks(Long userId) throws InvalidIdentifierException;

}
