package com.appchana.books.controller;

import com.appchana.books.controller.mapper.UserBookMapper;
import com.appchana.books.dao.model.UserBook;
import com.appchana.books.dto.UserBookDTO;
import com.appchana.books.exception.ConstraintsViolationException;
import com.appchana.books.exception.EntityNotFoundException;
import com.appchana.books.exception.InvalidIdentifierException;
import com.appchana.books.service.userbook.UserBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

/**
 * All operations with a userbooks will be routed by this controller.
 */
@RestController
@RequestMapping("v1/userbooks")
public class UserBookController
{
    @Autowired
    private final UserBookService userBookService;


    public UserBookController(final UserBookService userBookService)
    {
        this.userBookService = userBookService;
    }


    @GetMapping("/{userBookId}")
    public UserBookDTO getUserBook(@Valid @PathVariable long userBookId) throws EntityNotFoundException
    {
        return UserBookMapper.makeUserBookDTO(userBookService.find(userBookId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserBookDTO createUserBook(@Valid @RequestBody UserBookDTO userBookDTO) throws IOException, ConstraintsViolationException, InvalidIdentifierException
    {
        UserBook userBook = UserBookMapper.makeUserBook(userBookDTO);
        return UserBookMapper.makeUserBookDTO(userBookService.create(userBook));
    }

    @DeleteMapping("/{userBookId}")
    public void deleteUserBook(@Valid @PathVariable long userBookId) throws EntityNotFoundException
    {
        userBookService.delete(userBookId);
    }

    @GetMapping
    public List<UserBookDTO> findUserBooks(@RequestParam Long userId) throws EntityNotFoundException, InvalidIdentifierException
    {
        return UserBookMapper.makeUserBookDTOList(userBookService.findUserBooks(userId));
    }
}
