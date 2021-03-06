package com.appchana.books.controller.mapper;

import com.appchana.books.dto.UserDTO;
import com.appchana.books.dao.model.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper
{
    public static User makeUser(UserDTO userDTO)
    {
        return new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getOnlineStatus(), ContactMapper.makeContact(userDTO.getContact()), userDTO.getBooks());
    }


    public static UserDTO makeUserDTO(User user)
    {
        UserDTO.UserDTOBuilder userDTOBuilder = UserDTO.newBuilder()
            .setId(user.getId())
            .setPassword(user.getPassword())
            .setUsername(user.getUsername())
            .setOnlineStatus(user.getOnlineStatus())
            .setContact(ContactMapper.makeContactDTO(user.getContact()))
            .setBooks(user.getBooks());

        return userDTOBuilder.createUserDTO();
    }


    public static List<UserDTO> makeUserDTOList(Collection<User> users)
    {
        return users.stream()
            .map(UserMapper::makeUserDTO)
            .collect(Collectors.toList());
    }
}
