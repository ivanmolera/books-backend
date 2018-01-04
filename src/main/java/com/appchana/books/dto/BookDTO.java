package com.appchana.books.dto;

import javax.validation.constraints.NotNull;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO
{
    private Long bookId;

    private String googleBooksId;

    @NotNull(message = "ISBN-10 can not be null!")
    private String isbn10;

    private String isbn13;

    @NotNull(message = "Title type can not be null!")
    private String title;

    private String subtitle;

    private String synopsis;

    private String language;

    private Integer pageCount;

    private Double averageRating;

    private String cover;

    private BookDTO()
    {
    }


    public BookDTO(Long bookId, String googleBooksId, String isbn10, String isbn13, String title, String subtitle, String synopsis, String language, Integer pageCount, Double averageRating, String cover)
    {
        this.googleBooksId = googleBooksId;
        this.bookId = bookId;
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
        this.title = title;
        this.subtitle = subtitle;
        this.synopsis = synopsis;
        this.language = language;
        this.pageCount = pageCount;
        this.averageRating = averageRating;
        this.cover = cover;
    }


    public static BookDTOBuilder newBuilder()
    {
        return new BookDTOBuilder();
    }


    public Long getBookId()
    {
        return bookId;
    }

    public String getGoogleBooksId() {
        return googleBooksId;
    }

    public String getIsbn10() { return isbn10; }

    public String getIsbn13() { return isbn13; }

    public String getTitle() { return title; }

    public String getSubtitle() { return subtitle; }

    public String getSynopsis() { return synopsis; }

    public String getLanguage() { return language; }

    public Integer getPageCount() { return pageCount; }

    public Double getAverageRating() { return averageRating; }

    public String getCover() { return cover; }


    public static class BookDTOBuilder
    {
        private Long bookId;
        private String googleBooksId;
        private String isbn10;
        private String isbn13;
        private String title;
        private String subtitle;
        private String synopsis;
        private String language;
        private Integer pageCount;
        private Double averageRating;
        private String cover;


        public BookDTOBuilder setBookId(Long bookId)
        {
            this.bookId = bookId;
            return this;
        }


        public BookDTOBuilder setGoogleBooksId(String googleBooksId)
        {
            this.googleBooksId = googleBooksId;
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


        public BookDTOBuilder setSubtitle(String subtitle)
        {
            this.subtitle = subtitle;
            return this;
        }


        public BookDTOBuilder setSynopsis(String synopsis)
        {
            this.synopsis = synopsis;
            return this;
        }


        public BookDTOBuilder setLanguage(String language)
        {
            this.language = language;
            return this;
        }


        public BookDTOBuilder setPageCount(Integer pageCount)
        {
            this.pageCount = pageCount;
            return this;
        }


        public BookDTOBuilder setAverageRating(Double averageRating)
        {
            this.averageRating = averageRating;
            return this;
        }


        public BookDTOBuilder setCover(String cover)
        {
            this.cover = cover;
            return this;
        }


        public BookDTO createBookDTO()
        {
            return new BookDTO(bookId, googleBooksId, isbn10, isbn13, title, subtitle, synopsis, language, pageCount, averageRating, cover);
        }

    }
}
