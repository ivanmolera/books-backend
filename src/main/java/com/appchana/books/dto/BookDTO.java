package com.appchana.books.dto;

import com.appchana.books.controller.mapper.AuthorMapper;
import com.appchana.books.dao.model.Author;

import javax.validation.constraints.NotNull;
import java.util.List;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO
{
    private Long bookId;
    private String googleBooksId;
    private String isbn10;
    private String isbn13;
    private String title;
    private String subtitle;
    private String description;
    private String language;
    private Integer pageCount;
    private Double averageRating;
    private String cover;

    private List<AuthorDTO> authors;

    private BookDTO()
    {
    }


    public BookDTO(Long bookId, String googleBooksId, String isbn10, String isbn13, String title, String subtitle, String description, String language, Integer pageCount, Double averageRating, String cover, List<AuthorDTO> authors)
    {
        this.bookId = bookId;
        this.googleBooksId = googleBooksId;
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
        this.title = title;
        this.subtitle = subtitle;
        this.description = description;
        this.language = language;
        this.pageCount = pageCount;
        this.averageRating = averageRating;
        this.cover = cover;
        this.authors = authors;
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

    @NotNull(message = "ISBN-10 can not be null!")
    public String getIsbn10() { return isbn10; }

    public String getIsbn13() { return isbn13; }

    @NotNull(message = "Title type can not be null!")
    public String getTitle() { return title; }

    public String getSubtitle() { return subtitle; }

    public String getDescription() { return description; }

    public String getLanguage() { return language; }

    public Integer getPageCount() { return pageCount; }

    public Double getAverageRating() { return averageRating; }

    public String getCover() { return cover; }

    public List<AuthorDTO> getAuthors() { return authors; };


    public static class BookDTOBuilder
    {
        private Long bookId;
        private String googleBooksId;
        private String isbn10;
        private String isbn13;
        private String title;
        private String subtitle;
        private String description;
        private String language;
        private Integer pageCount;
        private Double averageRating;
        private String cover;
        private List<AuthorDTO> authors;


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


        public BookDTOBuilder setDescription(String description)
        {
            this.description = description;
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


        public BookDTOBuilder setAuthors(List<Author> authors)
        {
            this.authors = AuthorMapper.makeAuthorDTOList(authors);
            return this;
        }


        public BookDTO createBookDTO()
        {
            return new BookDTO(bookId, googleBooksId, isbn10, isbn13, title, subtitle, description, language, pageCount, averageRating, cover, authors);
        }

    }
}
