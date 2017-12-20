package com.appchana.books.controller;

import com.appchana.books.controller.mapper.BookMapper;
import com.appchana.books.dto.BookDTO;
import com.appchana.books.exception.EntityNotFoundException;
import com.appchana.books.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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


    @GetMapping("/{bookId}")
    public BookDTO getBook(@Valid @PathVariable long bookId) throws EntityNotFoundException
    {
        return BookMapper.makeBookDTO(bookService.find(bookId));
    }

    @GetMapping
    public List<BookDTO> findBooks(@RequestParam String isbn10)
        throws EntityNotFoundException
    {
        return BookMapper.makeBookDTOList(bookService.find(isbn10));
    }
}
