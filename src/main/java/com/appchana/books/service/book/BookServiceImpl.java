package com.appchana.books.service.book;

import com.appchana.books.controller.mapper.BookMapper;
import com.appchana.books.exception.ConstraintsViolationException;
import com.appchana.books.googlebooks.GoogleBooks;
import com.appchana.books.model.User;
import com.appchana.books.model.dao.BookRepository;
import com.appchana.books.model.Book;
import com.appchana.books.exception.EntityNotFoundException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class BookServiceImpl implements BookService
{

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(BookServiceImpl.class);

    private final BookRepository bookRepository;

    public BookServiceImpl(final BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }


    /**
     * Selects a book by id.
     *
     * @param bookId
     * @return found book
     * @throws EntityNotFoundException if no book with the given id was found.
     */
    @Override
    public Book find(Long bookId) throws EntityNotFoundException
    {
        return findBookChecked(bookId);
    }


    /**
     * Creates a new book.
     *
     * @param book
     * @return
     * @throws ConstraintsViolationException if a book already exists with the given ISBN
     */
    @Override
    public Book create(Book book) throws IOException, ConstraintsViolationException
    {
        Book newBook = null;

        List<Book> booksList = this.find(book.getIsbn10());
        if(booksList != null && !booksList.isEmpty()) {
            String message = "A book already exists with the given ISBN: " + book.getIsbn10();
            LOG.warn(message);
            throw new ConstraintsViolationException(message);
        }
        else {
            JSONObject jsonObject = GoogleBooks.searchBookByIsbn(book.getIsbn10());

            Integer totalItems = (Integer) jsonObject.get("totalItems");
            if (totalItems.intValue() > 0) {
                JSONArray items = (JSONArray) jsonObject.get("items");
                book = BookMapper.makeBook((JSONObject) items.get(0));
            }

            try {
                newBook = bookRepository.save(book);
            } catch (DataIntegrityViolationException e) {
                LOG.warn("Some constraints are thrown due to book creation", e);
                throw new ConstraintsViolationException(e.getMessage());
            }
        }
        return newBook;
    }

    /**
     * Deletes an existing book by id.
     *
     * @param bookId
     * @throws EntityNotFoundException if no book with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long bookId) throws EntityNotFoundException
    {
        Book book = findBookChecked(bookId);
        book.setDeleted(true);
    }

    /**
     * Find all books by ISBN-10.
     *
     * @param isbn10
     */
    @Override
    public List<Book> find(String isbn10) { return bookRepository.findByIsbn10(isbn10); }


    private Book findBookChecked(Long bookId) throws EntityNotFoundException
    {
        Book book = bookRepository.findOne(bookId);
        if (book == null)
        {
            throw new EntityNotFoundException("Could not find entity with id: " + bookId);
        }
        return book;
    }
}
