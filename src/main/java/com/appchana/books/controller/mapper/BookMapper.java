package com.appchana.books.controller.mapper;

import com.appchana.books.dao.model.Book;
import com.appchana.books.dto.BookDTO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BookMapper
{
    public static Book makeBook(BookDTO bookDTO)
    {
        return new Book(bookDTO.getGoogleBooksId(), bookDTO.getIsbn10(), bookDTO.getIsbn13(), bookDTO.getTitle(), bookDTO.getSubtitle(), bookDTO.getDescription(), bookDTO.getLanguage(), bookDTO.getPageCount(), bookDTO.getAverageRating(), bookDTO.getCover(), bookDTO.getConditionType(), bookDTO.getPicture01(), bookDTO.getPicture02(), bookDTO.getPicture03(), AuthorMapper.makeAuthorList(bookDTO.getAuthors()));
    }

    public static BookDTO makeBookDTO(Book book)
    {
        BookDTO.BookDTOBuilder bookDTOBuilder = BookDTO.newBuilder()
            .setId(book.getId())
            .setGoogleBooksId(book.getGoogleBooksId())
            .setIsbn10(book.getIsbn10())
            .setIsbn13(book.getIsbn13())
            .setTitle(book.getTitle())
            .setSubtitle(book.getSubtitle())
            .setDescription(book.getDescription())
            .setLanguage(book.getLanguage())
            .setPageCount(book.getPageCount())
            .setAverageRating(book.getAverageRating())
            .setCover(book.getCover())
            .setConditionType(book.getConditionType())
            .setPicture01(book.getPicture01())
            .setPicture02(book.getPicture02())
            .setPicture03(book.getPicture03())
            .setAuthors(AuthorMapper.makeAuthorDTOList(book.getAuthors()));

        return bookDTOBuilder.createBookDTO();
    }


    public static List<BookDTO> makeBookDTOList(Collection<Book> books)
    {
        return books.stream()
            .map(BookMapper::makeBookDTO)
            .collect(Collectors.toList());
    }
}
