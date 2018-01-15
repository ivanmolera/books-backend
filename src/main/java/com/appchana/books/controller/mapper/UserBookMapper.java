package com.appchana.books.controller.mapper;

import com.appchana.books.dao.model.UserBook;
import com.appchana.books.dto.UserBookDTO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ivanmolera on 04/01/2018.
 */
public class UserBookMapper {
    public static UserBook makeUserBook(UserBookDTO userBookDTO)
    {
        return new UserBook(userBookDTO.getConditionType(), userBookDTO.getPicture01(), userBookDTO.getPicture02(), userBookDTO.getPicture03());
    }

    public static UserBookDTO makeUserBookDTO(UserBook userBook)
    {
        UserBookDTO.UserBookDTOBuilder userBookDTOBuilder = UserBookDTO.newBuilder()
                .setUserBookId(userBook.getUserBookId())
                .setUser(UserMapper.makeUserDTO(userBook.getUser()))
                .setBook(BookMapper.makeBookDTO(userBook.getBook()))
                .setConditionType(userBook.getConditionType())
                .setPicture01(userBook.getPicture01())
                .setPicture02(userBook.getPicture02())
                .setPicture03(userBook.getPicture03());

        return userBookDTOBuilder.createUserBookDTO();
    }


    public static List<UserBookDTO> makeUserBookDTOList(Collection<UserBook> userBooks)
    {
        return userBooks.stream()
                .map(UserBookMapper::makeUserBookDTO)
                .collect(Collectors.toList());
    }
}
