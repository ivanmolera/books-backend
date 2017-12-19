package com.appchana.books.controller.mapper;

import com.appchana.books.model.Book;
import com.appchana.books.dto.BookDTO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BookMapper
{
    public static Book makeBookDO(BookDTO bookDTO)
    {
        return new Book(bookDTO.getIsbn(), bookDTO.getTitle());
    }


    public static BookDTO makeBookDTO(Book book)
    {
        BookDTO.BookDTOBuilder bookDTOBuilder = BookDTO.newBuilder()
            .setBookId(book.getBookId())
            .setIsbn(book.getIsbn())
            .setTitle(book.getTitle());

        return bookDTOBuilder.createBookDTO();
    }


    public static List<BookDTO> makeBookDTOList(Collection<Book> books)
    {
        return books.stream()
            .map(BookMapper::makeBookDTO)
            .collect(Collectors.toList());
    }
}
