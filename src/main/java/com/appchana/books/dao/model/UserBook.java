package com.appchana.books.dao.model;

import com.appchana.books.domainvalue.ConditionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

/**
 * Created by ivanmolera on 04/01/2018.
 */
@Entity
@Table(name = "users_books")
public class UserBook {

    @JsonIgnore
    private Long userBookId;
    private ZonedDateTime dateCreated = ZonedDateTime.now();
    private Boolean deleted = false;
    private ConditionType conditionType;
    private String picture01;
    private String picture02;
    private String picture03;

    private User user;
    private Book book;


    private UserBook() {
    }

    public UserBook(ConditionType conditionType, String picture01, String picture02, String picture03) {
        this.conditionType = conditionType;
        this.picture01 = picture01;
        this.picture02 = picture02;
        this.picture03 = picture03;
    }

    @Id
    @GeneratedValue
    @Column(name = "user_book_id")
    public Long getUserBookId() { return userBookId; }

    public void setUserBookId(Long userBookId) { this.userBookId = userBookId; }


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }


    @Column(nullable = false)
    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
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


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull(message = "UserId can not be null!")
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", nullable = false)
    @NotNull(message = "BookId can not be null!")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
