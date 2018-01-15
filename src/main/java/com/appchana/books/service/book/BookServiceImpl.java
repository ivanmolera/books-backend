package com.appchana.books.service.book;

import com.appchana.books.common.Constants;
import com.appchana.books.controller.mapper.BookMapper;
import com.appchana.books.exception.ConstraintsViolationException;
import com.appchana.books.exception.EntityNotFoundException;
import com.appchana.books.exception.InvalidIdentifierException;
import com.appchana.books.googlebooks.GoogleBooksAPIService;
import com.appchana.books.dao.model.Book;
import com.appchana.books.dao.BookRepository;
import com.appchana.books.util.CheckISBN;
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
     * @param id
     * @return found book
     * @throws EntityNotFoundException if no book with the given id was found.
     */
    @Override
    public Book find(String id) throws EntityNotFoundException
    {
        return findBookChecked(id);
    }

    /**
     * Creates a new book.
     *
     * @param book
     * @return
     * @throws ConstraintsViolationException if a book already exists with the given ISBN
     */
    @Override
    public Book create(Book book) throws IOException, ConstraintsViolationException, InvalidIdentifierException
    {
        Book newBook = null;

        List<Book> booksList = this.findByISBN(CheckISBN.getISBN(book));
        if(booksList != null && !booksList.isEmpty()) {
            String message = "A book already exists with the given ISBN: " + book.getIsbn10();
            LOG.warn(message);
            throw new ConstraintsViolationException(message);
        }
        else {
            JSONObject jsonObject = GoogleBooksAPIService.searchBookByIsbn(book.getIsbn10());

            if(jsonObject != null && jsonObject.length() > 0) {
                JSONArray items = (JSONArray) jsonObject.get("items");
                book = GoogleBooksAPIService.parseBookWithBasicInfo((JSONObject) items.get(0));

                JSONObject jsonVolume = GoogleBooksAPIService.searchBookByGoogleBooksId(book.getGoogleBooksId());
                book = GoogleBooksAPIService.parseBook(jsonVolume);
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
     * @param id
     * @throws EntityNotFoundException if no book with the given id was found.
     */
    @Override
    @Transactional
    public void delete(String id) throws EntityNotFoundException
    {
        Book book = findBookChecked(id);
        bookRepository.delete(book);
    }

    /**
     * Find all books by ISBN, ...
     *
     * @param isbn
     */
    @Override
    public List<Book> findByISBN(String isbn) throws InvalidIdentifierException
    {
        List<Book> booksList;
        String isbnType = CheckISBN.getISBNType(isbn);
        if(isbnType != null) {
            if (Constants.ISBN_10.equals(isbnType)) {
                booksList = bookRepository.findByIsbn10(isbn);
            }
            else {
                booksList = bookRepository.findByIsbn13(isbn);
            }
        }
        else {
            throw new InvalidIdentifierException("Invalid ISBN: " + isbn);
        }
        return booksList;
    }

    private Book findBookChecked(String id) throws EntityNotFoundException
    {
        Book book = bookRepository.findOne(id);
        if (book == null)
        {
            throw new EntityNotFoundException("Could not find entity with id: " + id);
        }
        return book;
    }
}
