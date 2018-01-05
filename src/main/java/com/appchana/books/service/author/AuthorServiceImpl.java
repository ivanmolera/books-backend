package com.appchana.books.service.author;


import com.appchana.books.dao.AuthorRepository;
import com.appchana.books.dao.model.Author;
import com.appchana.books.exception.ConstraintsViolationException;
import com.appchana.books.exception.EntityNotFoundException;
import com.appchana.books.exception.InvalidIdentifierException;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * Created by ivanmolera on 05/01/2018.
 */
@Service
public class AuthorServiceImpl implements AuthorService {
    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(AuthorServiceImpl.class);

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(final AuthorRepository authorRepository)
    {
        this.authorRepository = authorRepository;
    }


    /**
     * Selects a author by id.
     *
     * @param authorId
     * @return found author
     * @throws EntityNotFoundException if no author with the given id was found.
     */
    @Override
    public Author find(Long authorId) throws EntityNotFoundException
    {
        return findAuthorChecked(authorId);
    }

    /**
     * Creates a new author.
     *
     * @param author
     * @return
     * @throws ConstraintsViolationException if an author already exists with the given name and surname
     */
    @Override
    public Author create(Author author) throws IOException, ConstraintsViolationException, InvalidIdentifierException
    {
        Author newAuthor = null;

        List<Author> authorsList = authorRepository.findByNameAndSurname(author.getName(), author.getSurname());
        if(authorsList != null && !authorsList.isEmpty()) {
            String message = "A author already exists with the given name: " + author.getName() + " and surname:" + author.getSurname();
            LOG.warn(message);
            throw new ConstraintsViolationException(message);
        }
        else {
            try {
                newAuthor = authorRepository.save(author);
            } catch (DataIntegrityViolationException e) {
                LOG.warn("Some constraints are thrown due to author creation", e);
                throw new ConstraintsViolationException(e.getMessage());
            }
        }
        return newAuthor;
    }

    /**
     * Deletes an existing author by id.
     *
     * @param authorId
     * @throws EntityNotFoundException if no author with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long authorId) throws EntityNotFoundException
    {
        Author author = findAuthorChecked(authorId);
        author.setDeleted(true);
    }

    /**
     * Find all authors by name, surname, ...
     *
     * @param name
     * @param surname
     */
    @Override
    public List<Author> find(String name, String surname) throws InvalidIdentifierException
    {
        List<Author> authorsList = authorRepository.findByNameAndSurname(name, surname);
        return authorsList;
    }

    private Author findAuthorChecked(Long authorId) throws EntityNotFoundException
    {
        Author author = authorRepository.findOne(authorId);
        if (author == null)
        {
            throw new EntityNotFoundException("Could not find entity with id: " + authorId);
        }
        return author;
    }
}
