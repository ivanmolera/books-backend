package com.appchana.books.dao.model;

import com.appchana.books.domainvalue.OnlineStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

@Document(collection = "users")
public class User
{
    @Id
    private String id;
    private String username;
    private String password;
    private Boolean deleted = false;
    private OnlineStatus onlineStatus;

    private Contact contact;

    // Referenced documents
    private List<String> books;

    private User()
    {
    }


    public User(String username, String password, Contact contact)
    {
        this.username = username;
        this.password = password;
        this.deleted = false;
        this.onlineStatus = OnlineStatus.OFFLINE;
        this.contact = contact;
    }

    public User(String username, String password, OnlineStatus onlineStatus, Contact contact, List<String> books)
    {
        this.username = username;
        this.password = password;
        this.deleted = false;
        this.onlineStatus = onlineStatus != null ? onlineStatus : OnlineStatus.OFFLINE;
        this.contact = contact;
        this.books = books;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NotNull(message = "Username can not be null!")
    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @NotNull(message = "Password can not be null!")
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


    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }


    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}
