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

    @NotNull(message = "ISBN-10 can not be null!")
    private String isbn10;

    private String isbn13;

    @NotNull(message = "Title type can not be null!")
    private String title;

    private Float averageRating;

    private BookDTO()
    {
    }


    public BookDTO(Long bookId, String isbn10, String isbn13, String title, Float averageRating)
    {
        this.bookId = bookId;
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
        this.title = title;
        this.averageRating = averageRating;
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
    public String getIsbn10() { return isbn10; }

    public String getIsbn13() { return isbn13; }

    public String getTitle() { return title; }

    public Float getAverageRating() { return averageRating; }


    public static class BookDTOBuilder
    {
        private Long bookId;
        private String isbn10;
        private String isbn13;
        private String title;
        private Float averageRating;


        public BookDTOBuilder setBookId(Long bookId)
        {
            this.bookId = bookId;
            return this;
        }


        public BookDTOBuilder setIsbn10(String isbn10)
        {
            this.isbn10 = isbn10;
            return this;
        }


        public BookDTOBuilder setIsbn13(String isbn13)
        {
            this.isbn13 = isbn13;
            return this;
        }


        public BookDTOBuilder setTitle(String title)
        {
            this.title = title;
            return this;
        }


        public BookDTOBuilder setAverageRating(Float averageRating)
        {
            this.averageRating = averageRating;
            return this;
        }


        public BookDTO createBookDTO()
        {
            return new BookDTO(bookId, isbn10, isbn13, title, averageRating);
        }

    }
}
