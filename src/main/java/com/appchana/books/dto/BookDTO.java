package com.appchana.books.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO
{
    @JsonIgnore
    private Long bookId;

    @NotNull(message = "ISBN can not be null!")
    private String isbn;

    @NotNull(message = "Title type can not be null!")
    private String title;

    private BookDTO()
    {
    }


    public BookDTO(Long bookId, String isbn, String title)
    {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
    }


    public static BookDTOBuilder newBuilder()
    {
        return new BookDTOBuilder();
    }


    @JsonProperty
    public Long getBookId()
    {
        return bookId;
    }

    @JsonProperty
    public String getIsbn() { return isbn; }

    public String getTitle() { return title; }


    public static class BookDTOBuilder
    {
        private Long bookId;
        private String isbn;
        private String title;


        public BookDTOBuilder setBookId(Long bookId)
        {
            this.bookId = bookId;
            return this;
        }


        public BookDTOBuilder setIsbn(String isbn)
        {
            this.isbn = isbn;
            return this;
        }


        public BookDTOBuilder setTitle(String title)
        {
            this.title = title;
            return this;
        }


        public BookDTO createBookDTO()
        {
            return new BookDTO(bookId, isbn, title);
        }

    }
}
