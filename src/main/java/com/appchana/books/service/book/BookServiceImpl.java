package com.appchana.books.service.book;

import com.appchana.books.model.dao.BookRepository;
import com.appchana.books.model.Book;
import com.appchana.books.exception.EntityNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
