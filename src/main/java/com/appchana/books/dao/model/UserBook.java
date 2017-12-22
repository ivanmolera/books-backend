package com.appchana.books.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Entity
@Table(
    name = "user_books",
    uniqueConstraints = @UniqueConstraint(name = "uc_user_books", columnNames = {"userId", "bookId"})
)
public class UserBook
{

    @Id
    @GeneratedValue
    private Long userBookId;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column(nullable = false)
    @NotNull(message = "UserId can not be null!")
    private Long userId;

    @Column(nullable = false)
    @NotNull(message = "BookId can not be null!")
    private Long bookId;

    @Column(nullable = false)
    private Boolean deleted = false;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    private UserBook()
    {
    }


    public UserBook(Long userId, Long bookId)
    {
        this.userId = userId;
        this.bookId = bookId;
        this.deleted = false;
    }

    public UserBook(Long userId, Long bookId, User user)
    {
        this.userId = userId;
        this.bookId = bookId;
        this.deleted = false;
        this.user = user;
    }


    public Long getUserBookId() { return userBookId; }

    public void setUserBookId(Long userBookId) { this.userBookId = userBookId; }

    public Long getUserId() { return userId; }

    public Long getBookId() {
        return bookId;
    }

    public Boolean getDeleted()
    {
        return deleted;
    }

    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
