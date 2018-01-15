package com.appchana.books.controller;

import com.appchana.books.controller.mapper.BookMapper;
import com.appchana.books.controller.mapper.UserMapper;
import com.appchana.books.dao.model.User;
import com.appchana.books.domainvalue.OnlineStatus;
import com.appchana.books.dto.BookDTO;
import com.appchana.books.dto.UserDTO;
import com.appchana.books.exception.ConstraintsViolationException;
import com.appchana.books.exception.EntityNotFoundException;
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

    @GetMapping("/{id}")
    public UserDTO getUser(@Valid @PathVariable String id) throws EntityNotFoundException
    {
        return UserMapper.makeUserDTO(userService.find(id));
    }

    /*
    @GetMapping("/{id}/books")
    public List<BookDTO> getUserBooks(@Valid @PathVariable String id) throws EntityNotFoundException
    {
        User user = userService.find(id);
        return BookMapper.makeBookDTOList(user.getBooks());
    }
    */

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
