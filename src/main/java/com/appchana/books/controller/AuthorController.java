package com.appchana.books.controller;

import com.appchana.books.controller.mapper.AuthorMapper;
import com.appchana.books.controller.mapper.BookMapper;
import com.appchana.books.dao.model.Author;
import com.appchana.books.dto.AuthorDTO;
import com.appchana.books.dto.BookDTO;
import com.appchana.books.exception.ConstraintsViolationException;
import com.appchana.books.exception.EntityNotFoundException;
import com.appchana.books.exception.InvalidIdentifierException;
import com.appchana.books.service.author.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * All operations with authors will be routed by this controller.
 */
@RestController
@RequestMapping("v1/authors")
public class AuthorController
{
    @Autowired
    private final AuthorService authorService;


    public AuthorController(final AuthorService authorService)
    {
        this.authorService = authorService;
    }


    @GetMapping("/{id}")
    public AuthorDTO getAuthor(@Valid @PathVariable String id) throws EntityNotFoundException
    {
        return AuthorMapper.makeAuthorDTO(authorService.find(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDTO createAuthor(@Valid @RequestBody AuthorDTO authorDTO) throws IOException, ConstraintsViolationException, InvalidIdentifierException
    {
        Author author = AuthorMapper.makeAuthor(authorDTO);
        return AuthorMapper.makeAuthorDTO(authorService.create(author));
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@Valid @PathVariable String id) throws EntityNotFoundException
    {
        authorService.delete(id);
        return "Author deleted";
    }

    /*
    @GetMapping("/{id}/books")
    public List<BookDTO> getAuthorBooks(@Valid @PathVariable String id) throws EntityNotFoundException
    {
        Author author = authorService.find(id);
        return BookMapper.makeBookDTOList(author.getBooks());
    }
    */

    @GetMapping
    public List<AuthorDTO> findAuthors(@RequestParam String name, @RequestParam String surname) throws EntityNotFoundException, InvalidIdentifierException
    {
        return AuthorMapper.makeAuthorDTOList(authorService.find(name, surname));
    }
}
