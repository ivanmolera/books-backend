package com.appchana.books.service.user;

import com.appchana.books.dao.model.Book;
import com.appchana.books.domainvalue.OnlineStatus;
import com.appchana.books.exception.ConstraintsViolationException;
import com.appchana.books.exception.EntityNotFoundException;
import com.appchana.books.dao.model.User;

import java.util.List;

public interface UserService  {

    User find(String id) throws EntityNotFoundException;

    User create(User user) throws ConstraintsViolationException;

    User insertUserBook(String userId, Book book) throws EntityNotFoundException, ConstraintsViolationException;

    void delete(String id) throws EntityNotFoundException;

    List<User> find(OnlineStatus onlineStatus);

    User findByUsername(String username);
}
