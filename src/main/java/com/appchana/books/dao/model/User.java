package com.appchana.books.dao.model;

import com.appchana.books.domainvalue.OnlineStatus;
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
    name = "users",
    uniqueConstraints = @UniqueConstraint(name = "uc_users_username", columnNames = {"username"})
)
public class User
{

    @Id
    @GeneratedValue
    private Long userId;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column(nullable = false)
    @NotNull(message = "Username can not be null!")
    private String username;

    @Column(nullable = false)
    @NotNull(message = "Password can not be null!")
    private String password;

    @Column(nullable = false)
    private Boolean deleted = false;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OnlineStatus onlineStatus;


    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}
    )
    @JoinTable(
            name = "user_books",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;

    private User()
    {
    }


    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.deleted = false;
        this.onlineStatus = OnlineStatus.OFFLINE;
    }


    public Long getUserId() { return userId; }


    public void setUserId(Long userId) { this.userId = userId; }


    public String getUsername()
    {
        return username;
    }


    public String getPassword()
    {
        return password;
    }


    public void setPassword(String password) { this.password = password; }


    public Boolean getDeleted()
    {
        return deleted;
    }


    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }


    public OnlineStatus getOnlineStatus()
    {
        return onlineStatus;
    }


    public void setOnlineStatus(OnlineStatus onlineStatus)
    {
        this.onlineStatus = onlineStatus;
    }


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        if(this.books == null) {
            this.books = new ArrayList();
        }

        this.books.add(book);
    }
}
