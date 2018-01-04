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
        return new Book(bookDTO.getGoogleBooksId(), bookDTO.getIsbn10(), bookDTO.getIsbn13(), bookDTO.getTitle(), bookDTO.getSubtitle(), bookDTO.getSynopsis(), bookDTO.getLanguage(), bookDTO.getPageCount(), bookDTO.getAverageRating(), bookDTO.getCover());
    }

    public static BookDTO makeBookDTO(Book book)
    {
        BookDTO.BookDTOBuilder bookDTOBuilder = BookDTO.newBuilder()
            .setGoogleBooksId(book.getGoogleBooksId())
            .setBookId(book.getBookId())
            .setIsbn10(book.getIsbn10())
            .setIsbn13(book.getIsbn13())
            .setTitle(book.getTitle())
            .setSubtitle(book.getSubtitle())
            .setSynopsis(book.getSynopsis())
            .setLanguage(book.getLanguage())
            .setPageCount(book.getPageCount())
            .setAverageRating(book.getAverageRating())
            .setCover(book.getCover());

        return bookDTOBuilder.createBookDTO();
    }


    public static List<BookDTO> makeBookDTOList(Collection<Book> books)
    {
        return books.stream()
            .map(BookMapper::makeBookDTO)
            .collect(Collectors.toList());
    }
}
