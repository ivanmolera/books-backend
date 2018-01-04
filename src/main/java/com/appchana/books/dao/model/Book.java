package com.appchana.books.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(
    name = "books", uniqueConstraints = {
        @UniqueConstraint(name = "uc_books_isbn10", columnNames = "isbn10"),
        @UniqueConstraint(name = "uc_books_isbn13", columnNames = "isbn13")
    }
)
public class Book
{
    private Long bookId;
    private ZonedDateTime dateCreated = ZonedDateTime.now();
    private String isbn10;
    private String isbn13;
    private String title;
    private String subtitle;
    private String synopsis;
    private String language;
    private Integer pageCount;
    private Double averageRating;
    private String cover;
    private Boolean deleted = false;

    private List<UserBook> userBooks = new ArrayList<UserBook>();

    private Book()
    {
    }


    public Book(String isbn10, String isbn13, String title, String subtitle, String synopsis, String language, Integer pageCount, Double averageRating, String cover)
    {
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
        this.title = title;
        this.subtitle = subtitle;
        this.synopsis = synopsis;
        this.language = language;
        this.pageCount = pageCount;
        this.averageRating = averageRating;
        this.cover = cover;
        this.deleted = false;
    }


    @Id
    @GeneratedValue
    @Column(name = "book_id")
    public Long getBookId() { return bookId; }

    public void setBookId(Long bookId) { this.bookId = bookId; }

    @JsonIgnore
    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }


    @Column(nullable = false)
    @NotNull(message = "ISBN-10 can not be null!")
    public String getIsbn10() { return isbn10; }

    public void setIsbn10(String isbn10) { this.isbn10 = isbn10; }


    public String getIsbn13() { return isbn13; }

    public void setIsbn13(String isbn13) { this.isbn13 = isbn13; }


    @Column(nullable = false)
    @NotNull(message = "Title can not be null!")
    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }


    public String getSubtitle() { return subtitle; }

    public void setSubtitle(String subtitle) { this.subtitle = subtitle; }


    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
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


    @Column(nullable = false)
    public Boolean getDeleted() { return deleted; }

    public void setDeleted(Boolean deleted) { this.deleted = deleted; }


    @JsonIgnore
    @OneToMany(mappedBy = "book")
    public List<UserBook> getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(List<UserBook> userBooks) {
        this.userBooks = userBooks;
    }
}
