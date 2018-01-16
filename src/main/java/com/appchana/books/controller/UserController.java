package com.appchana.books.controller;

import com.appchana.books.controller.mapper.BookMapper;
import com.appchana.books.controller.mapper.UserMapper;
import com.appchana.books.dao.model.Book;
import com.appchana.books.dao.model.User;
import com.appchana.books.domainvalue.OnlineStatus;
import com.appchana.books.dto.BookDTO;
import com.appchana.books.dto.UserDTO;
import com.appchana.books.exception.ConstraintsViolationException;
import com.appchana.books.exception.EntityNotFoundException;
import com.appchana.books.exception.InvalidIdentifierException;
import com.appchana.books.service.book.BookService;
import com.appchana.books.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * All operations with a user will be routed by this controller.
 */
@RestController
@RequestMapping("v1/users")
public class UserController
{

    protected final UserService userService;
    protected final BookService bookService;


    @Autowired
    public UserController(final UserService userService, final BookService bookService)
    {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@Valid @PathVariable String id) throws EntityNotFoundException
    {
        return UserMapper.makeUserDTO(userService.find(id));
    }

    @GetMapping("/{id}/books")
    public List<BookDTO> getUserBooks(@Valid @PathVariable String id) throws EntityNotFoundException
    {
        User user = userService.find(id);
        List<String> booksList = user.getBooks();

        return bookService.getUserBooks(booksList);
    }

    @PostMapping("/{id}/books")
    @ResponseStatus(HttpStatus.CREATED)
    public List<String> insertUserBook(@Valid @PathVariable String id, @Valid @RequestBody BookDTO bookDTO) throws IOException, EntityNotFoundException, ConstraintsViolationException, InvalidIdentifierException
    {
        Book book = bookService.create(BookMapper.makeBook(bookDTO));
        User user = userService.insertUserBook(id, book);
        return user.getBooks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) throws ConstraintsViolationException
    {
        User user = UserMapper.makeUser(userDTO);
        return UserMapper.makeUserDTO(userService.create(user));
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@Valid @PathVariable String id) throws EntityNotFoundException
    {
        userService.delete(id);
        return "User deleted";
    }


    @GetMapping
    public List<UserDTO> findUsers(@RequestParam OnlineStatus onlineStatus)
        throws ConstraintsViolationException, EntityNotFoundException
    {
        return UserMapper.makeUserDTOList(userService.find(onlineStatus));
    }
}
