package com.appchana.books.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Entity
@Table(
    name = "BOOKS",
    uniqueConstraints = @UniqueConstraint(name = "uc_book_isbn", columnNames = {"isbn"})
)
public class Book
{
/*
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private DriverDO driver;
*/
    @Id
    @GeneratedValue
    private Long bookId;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime entryDate = ZonedDateTime.now();

    @Column(nullable = false)
    @NotNull(message = "ISBN can not be null!")
    private String isbn;

    @Column(nullable = false)
    @NotNull(message = "Title can not be null!")
    private String title;


    private Book()
    {
    }


    public Book(String isbn, String title)
    {
        this.isbn = isbn;
        this.title = title;
    }


    public Long getBookId() { return bookId; }

    public void setBookId(Long bookId) { this.bookId = bookId; }


    public String getIsbn() { return isbn; }

    public void setIsbn(String isbn) { this.isbn = isbn; }


    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }
}
