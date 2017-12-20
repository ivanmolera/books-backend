package com.appchana.books.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Entity
@Table(
    name = "books",
    uniqueConstraints = @UniqueConstraint(name = "uc_books_isbn", columnNames = {"isbn10"})
)
public class Book
{
    @Id
    @GeneratedValue
    private Long bookId;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column(nullable = false)
    @NotNull(message = "ISBN-10 can not be null!")
    private String isbn10;

    private String isbn13;

    @Column(nullable = false)
    @NotNull(message = "Title can not be null!")
    private String title;

    private Float averageRating;

    @Column(nullable = false)
    private Boolean deleted = false;

    private Book()
    {
    }


    public Book(String isbn10, String isbn13, String title, Float averageRating)
    {
        this.isbn10 = isbn10;
        this.isbn13 = isbn13;
        this.title = title;
        this.averageRating = averageRating;
        this.deleted = false;
    }


    public Long getBookId() { return bookId; }

    public void setBookId(Long bookId) { this.bookId = bookId; }


    public String getIsbn10() { return isbn10; }

    public void setIsbn10(String isbn10) { this.isbn10 = isbn10; }


    public String getIsbn13() { return isbn13; }

    public void setIsbn13(String isbn13) { this.isbn10 = isbn13; }


    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }


    public Float getAverageRating() { return averageRating; }

    public void setAverageRating(Float averageRating) { this.averageRating = averageRating; }


    public Boolean getDeleted() { return deleted; }

    public void setDeleted(Boolean deleted) { this.deleted = deleted; }
}
