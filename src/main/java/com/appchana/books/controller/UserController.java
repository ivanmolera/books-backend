package com.appchana.books.controller;

import com.appchana.books.controller.mapper.BookMapper;
import com.appchana.books.controller.mapper.UserMapper;
import com.appchana.books.dao.model.Book;
import com.appchana.books.domainvalue.OnlineStatus;
import com.appchana.books.dto.BookDTO;
import com.appchana.books.dto.UserDTO;
import com.appchana.books.exception.ConstraintsViolationException;
import com.appchana.books.exception.EntityNotFoundException;
import com.appchana.books.dao.model.User;
import com.appchana.books.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * All operations with a user will be routed by this controller.
 */
@RestController
@RequestMapping("v1/users")
public class UserController
{

    protected final UserService userService;


    @Autowired
    public UserController(final UserService userService)
    {
        this.userService = userService;
    }


    @GetMapping("/{userId}")
    public UserDTO getUser(@Valid @PathVariable long userId) throws EntityNotFoundException
    {
        return UserMapper.makeUserDTO(userService.find(userId));
    }

    @GetMapping("/{userId}/books")
    public List<BookDTO> getUserBooks(@Valid @PathVariable long userId) throws EntityNotFoundException
    {
        User user = userService.find(userId);
        return BookMapper.makeBookDTOList(user.getBooks());
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) throws ConstraintsViolationException
    {
        User userDO = UserMapper.makeUser(userDTO);
        return UserMapper.makeUserDTO(userService.create(userDO));
    }


    @DeleteMapping("/{userId}")
    public void deleteUser(@Valid @PathVariable long userId) throws EntityNotFoundException
    {
        userService.delete(userId);
    }


    @GetMapping
    public List<UserDTO> findUsers(@RequestParam OnlineStatus onlineStatus)
        throws ConstraintsViolationException, EntityNotFoundException
    {
        return UserMapper.makeUserDTOList(userService.find(onlineStatus));
    }
}
