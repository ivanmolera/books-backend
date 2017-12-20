package com.appchana.books.service.user;

import com.appchana.books.domainvalue.OnlineStatus;
import com.appchana.books.exception.ConstraintsViolationException;
import com.appchana.books.exception.EntityNotFoundException;
import com.appchana.books.model.User;

import java.util.List;

public interface UserService  {

    User find(Long userId) throws EntityNotFoundException;

    User create(User user) throws ConstraintsViolationException;

    void delete(Long userId) throws EntityNotFoundException;

    List<User> find(OnlineStatus onlineStatus);
}
