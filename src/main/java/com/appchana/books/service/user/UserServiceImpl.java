package com.appchana.books.service.user;

import com.appchana.books.domainvalue.OnlineStatus;
import com.appchana.books.exception.ConstraintsViolationException;
import com.appchana.books.exception.EntityNotFoundException;
import com.appchana.books.dao.model.User;
import com.appchana.books.dao.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
     * @param userId
     * @return found user
     * @throws EntityNotFoundException if no user with the given id was found.
     */
    @Override
    public User find(Long userId) throws EntityNotFoundException
    {
        return findUserChecked(userId);
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
        try
        {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            newUser = userRepository.save(user);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("Some constraints are thrown due to user creation", e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return newUser;
    }


    /**
     * Deletes an existing user by id.
     *
     * @param userId
     * @throws EntityNotFoundException if no user with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long userId) throws EntityNotFoundException
    {
        User user = findUserChecked(userId);
        user.setDeleted(true);
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


    private User findUserChecked(Long userId) throws EntityNotFoundException
    {
        User user = userRepository.findOne(userId);
        if (user == null)
        {
            throw new EntityNotFoundException("Could not find user with id: " + userId);
        }
        return user;
    }
}
