package com.appchana.books.controller.mapper;

import com.appchana.books.common.Constants;
import com.appchana.books.dao.model.Book;
import com.appchana.books.dao.model.UserBook;
import com.appchana.books.dto.BookDTO;
import com.appchana.books.dto.UserBookDTO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserBookMapper
{
    public static UserBook makeUserBook(UserBookDTO userBookDTO)
    {
        return new UserBook(userBookDTO.getUserId(), userBookDTO.getBookId());
    }

    public static UserBookDTO makeUserBookDTO(UserBook userBook)
    {
        UserBookDTO.UserBookDTOBuilder userBookDTOBuilder = UserBookDTO.newBuilder()
            .setUserBookId(userBook.getUserBookId())
            .setUserId(userBook.getUserId())
            .setBookId(userBook.getBookId());

        return userBookDTOBuilder.createUserBookDTO();
    }


    public static List<UserBookDTO> makeUserBookDTOList(Collection<UserBook> userBooks)
    {
        return userBooks.stream()
            .map(UserBookMapper::makeUserBookDTO)
            .collect(Collectors.toList());
    }
}
