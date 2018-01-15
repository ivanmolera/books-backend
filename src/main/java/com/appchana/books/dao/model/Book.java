package com.appchana.books.dao.model;

import com.appchana.books.domainvalue.ConditionType;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

public class Book
{
    @Id
    private String id;
    //private ZonedDateTime dateCreated = ZonedDateTime.now();
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
    private Boolean deleted = false;
    private ConditionType conditionType;
    private String picture01;
    private String picture02;
    private String picture03;

    private Book()
    {
    }

    public Book(String googleBooksId, String title)
    {
        this.googleBooksId = googleBooksId;
        this.title = title;
    }

    public Book(String googleBooksId, String isbn10, String isbn13, String title, String subtitle, String description, String language, Integer pageCount, Double averageRating, String cover, ConditionType conditionType, String picture01, String picture02, String picture03)
    {
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
        this.deleted = false;
        this.conditionType = conditionType;
        this.picture01 = picture01;
        this.picture02 = picture02;
        this.picture03 = picture03;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getGoogleBooksId() {
        return googleBooksId;
    }

    public void setGoogleBooksId(String googleBooksId) {
        this.googleBooksId = googleBooksId;
    }


    @NotNull(message = "ISBN-10 can not be null!")
    public String getIsbn10() { return isbn10; }

    public void setIsbn10(String isbn10) { this.isbn10 = isbn10; }


    public String getIsbn13() { return isbn13; }

    public void setIsbn13(String isbn13) { this.isbn13 = isbn13; }


    @NotNull(message = "Title can not be null!")
    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }


    public String getSubtitle() { return subtitle; }

    public void setSubtitle(String subtitle) { this.subtitle = subtitle; }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }


    public Double getAverageRating() { return averageRating; }

    public void setAverageRating(Double averageRating) { this.averageRating = averageRating; }


    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }


    public Boolean getDeleted() { return deleted; }

    public void setDeleted(Boolean deleted) { this.deleted = deleted; }


    public ConditionType getConditionType() {
        return conditionType;
    }

    public void setConditionType(ConditionType conditionType) {
        this.conditionType = conditionType;
    }


    public String getPicture01() {
        return picture01;
    }

    public void setPicture01(String picture01) {
        this.picture01 = picture01;
    }


    public String getPicture02() {
        return picture02;
    }

    public void setPicture02(String picture02) {
        this.picture02 = picture02;
    }


    public String getPicture03() {
        return picture03;
    }

    public void setPicture03(String picture03) {
        this.picture03 = picture03;
    }
}
