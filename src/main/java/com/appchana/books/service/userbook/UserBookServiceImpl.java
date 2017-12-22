package com.appchana.books.service.userbook;

import com.appchana.books.dao.UserBookRepository;
import com.appchana.books.dao.model.UserBook;
import com.appchana.books.exception.ConstraintsViolationException;
import com.appchana.books.exception.EntityNotFoundException;
import com.appchana.books.exception.InvalidIdentifierException;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class UserBookServiceImpl implements UserBookService
{

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(UserBookServiceImpl.class);

    private final UserBookRepository userBookRepository;

    public UserBookServiceImpl(final UserBookRepository userBookRepository)
    {
        this.userBookRepository = userBookRepository;
    }


    /**
     * Selects a userbook by id.
     *
     * @param userBookId
     * @return found userbook
     * @throws EntityNotFoundException if no userbook with the given id was found.
     */
    @Override
    public UserBook find(Long userBookId) throws EntityNotFoundException
    {
        return findBookChecked(userBookId);
    }

    /**
     * Creates a new userbook.
     *
     * @param userBook
     * @return
     * @throws ConstraintsViolationException if a userbook already exists with the given ISBN
     */
    @Override
    public UserBook create(UserBook userBook) throws IOException, ConstraintsViolationException, InvalidIdentifierException
    {
        UserBook newUserBook = null;
        try {
            newUserBook = userBookRepository.save(userBook);
        } catch (DataIntegrityViolationException e) {
            LOG.warn("Some constraints are thrown due to book creation", e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return newUserBook;
    }

    /**
     * Deletes an existing userBook by id.
     *
     * @param userBookId
     * @throws EntityNotFoundException if no userBook with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long userBookId) throws EntityNotFoundException
    {
        UserBook userBook = findBookChecked(userBookId);
        userBook.setDeleted(true);
    }

    /**
     * Find all userbooks by userId, ...
     *
     * @param userId
     */
    @Override
    public List<UserBook> findUserBooks(Long userId) throws InvalidIdentifierException
    {
        return userBookRepository.findByUserId(userId);
    }

    private UserBook findBookChecked(Long userBookId) throws EntityNotFoundException
    {
        UserBook userBook = userBookRepository.findOne(userBookId);
        if (userBook == null)
        {
            throw new EntityNotFoundException("Could not find entity with id: " + userBookId);
        }
        return userBook;
    }
}
