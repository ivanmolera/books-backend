package com.appchana.books.controller;

import com.appchana.books.controller.mapper.BookMapper;
import com.appchana.books.dto.BookDTO;
import com.appchana.books.exception.ConstraintsViolationException;
import com.appchana.books.exception.EntityNotFoundException;
import com.appchana.books.exception.InvalidIdentifierException;
import com.appchana.books.dao.model.Book;
import com.appchana.books.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * All operations with a book will be routed by this controller.
 */
@RestController
@RequestMapping("v1/books")
public class BookController
{
    @Autowired
    private final BookService bookService;


    public BookController(final BookService bookService)
    {
        this.bookService = bookService;
    }


    @GetMapping("/{id}")
    public BookDTO getBook(@Valid @PathVariable String id) throws EntityNotFoundException
    {
        return BookMapper.makeBookDTO(bookService.find(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createBook(@Valid @RequestBody BookDTO bookDTO) throws IOException, ConstraintsViolationException, InvalidIdentifierException
    {
        Book book = BookMapper.makeBook(bookDTO);
        return BookMapper.makeBookDTO(bookService.create(book));
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@Valid @PathVariable String id) throws EntityNotFoundException
    {
        bookService.delete(id);
        return "Book deleted";
    }

    @GetMapping
    public List<BookDTO> findBooks(@RequestParam String isbn) throws EntityNotFoundException, InvalidIdentifierException
    {
        return BookMapper.makeBookDTOList(bookService.findByISBN(isbn));
    }
}
