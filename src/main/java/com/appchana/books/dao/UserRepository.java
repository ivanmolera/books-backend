package com.appchana.books.dao;

import com.appchana.books.dao.model.User;
import com.appchana.books.domainvalue.OnlineStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Database Access Object for users table.
 */
public interface UserRepository extends CrudRepository<User, Long>
{

    List<User> findByOnlineStatus(OnlineStatus onlineStatus);

    User findByUsername(String username);
}
