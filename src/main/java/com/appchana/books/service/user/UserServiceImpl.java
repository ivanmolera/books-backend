package com.appchana.books.service.user;

import com.appchana.books.dao.UserRepository;
import com.appchana.books.dao.model.Book;
import com.appchana.books.dao.model.User;
import com.appchana.books.domainvalue.OnlineStatus;
import com.appchana.books.exception.ConstraintsViolationException;
import com.appchana.books.exception.EntityNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(final UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }


    /**
     * Selects a user by id.
     *
     * @param id
     * @return found user
     * @throws EntityNotFoundException if no user with the given id was found.
     */
    @Override
    public User find(String id) throws EntityNotFoundException
    {
        return findUserChecked(id);
    }


    /**
     * Creates a new user.
     *
     * @param user
     * @return
     * @throws ConstraintsViolationException if a user already exists with the given username
     */
    @Override
    public User create(User user) throws ConstraintsViolationException
    {
        User newUser = null;
        if(this.findByUsername(user.getUsername()) != null) {
            String message = "A user already exists with the given username: " + user.getUsername();
            LOG.warn(message);
            throw new ConstraintsViolationException(message);
        }
        else {
            try {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                newUser = userRepository.save(user);
            } catch (DataIntegrityViolationException e) {
                LOG.warn("Some constraints are thrown due to user creation", e);
                throw new ConstraintsViolationException(e.getMessage());
            }
        }
        return newUser;
    }

    /**
     * Updates a user.
     *
     * @param userId
     * @param book
     * @return
     * @throws ConstraintsViolationException
     */
    public User insertUserBook(String userId, Book book) throws EntityNotFoundException, ConstraintsViolationException
    {
        User user = findUserChecked(userId);

        List<String> booksList = user.getBooks();

        if(booksList == null) booksList = new ArrayList<String>();
        booksList.add(book.getId());

        user.setBooks(booksList);
        userRepository.save(user);

        return user;
    }


    /**
     * Deletes an existing user by id.
     *
     * @param id
     * @throws EntityNotFoundException if no user with the given id was found.
     */
    @Override
    @Transactional
    public void delete(String id) throws EntityNotFoundException
    {
        User user = findUserChecked(id);
        userRepository.delete(user);
    }


    /**
     * Find all users by online state.
     *
     * @param onlineStatus
     */
    @Override
    public List<User> find(OnlineStatus onlineStatus)
    {
        return userRepository.findByOnlineStatus(onlineStatus);
    }


    /**
     * Find all users by online state.
     *
     * @param username
     */
    @Override
    public User findByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }


    private User findUserChecked(String id) throws EntityNotFoundException
    {
        User user = userRepository.findOne(id);
        if (user == null)
        {
            throw new EntityNotFoundException("Could not find user with id: " + id);
        }
        return user;
    }
}
