package com.appchana.books.dto;

import com.appchana.books.domainvalue.ConditionType;

import javax.validation.constraints.NotNull;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDTO
{
    private String id;
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
    private ConditionType conditionType;
    private String picture01;
    private String picture02;
    private String picture03;

    private BookDTO()
    {
    }


    public BookDTO(String id, String googleBooksId, String isbn10, String isbn13, String title, String subtitle, String description, String language, Integer pageCount, Double averageRating, String cover, ConditionType conditionType, String picture01, String picture02, String picture03)
    {
        this.id = id;
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
        this.conditionType = conditionType;
        this.picture01 = picture01;
        this.picture02 = picture02;
        this.picture03 = picture03;
    }


    public static BookDTOBuilder newBuilder()
    {
        return new BookDTOBuilder();
    }


    public String getId() {
        return id;
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

    public ConditionType getConditionType() {
        return conditionType;
    }

    public String getPicture01() {
        return picture01;
    }

    public String getPicture02() {
        return picture02;
    }

    public String getPicture03() {
        return picture03;
    }

    public static class BookDTOBuilder
    {
        private String id;
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
        private ConditionType conditionType;
        private String picture01;
        private String picture02;
        private String picture03;


        public BookDTOBuilder setId(String id)
        {
            this.id = id;
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


        public BookDTOBuilder setConditionType(ConditionType conditionType)
        {
            this.conditionType = conditionType;
            return this;
        }


        public BookDTOBuilder setPicture01(String picture01)
        {
            this.picture01 = picture01;
            return this;
        }


        public BookDTOBuilder setPicture02(String picture02)
        {
            this.picture02 = picture02;
            return this;
        }


        public BookDTOBuilder setPicture03(String picture03)
        {
            this.picture03 = picture03;
            return this;
        }


        public BookDTO createBookDTO()
        {
            return new BookDTO(id, googleBooksId, isbn10, isbn13, title, subtitle, description, language, pageCount, averageRating, cover, conditionType, picture01, picture02, picture03);
        }

    }
}
