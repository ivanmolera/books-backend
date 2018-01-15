package com.appchana.books.dao.model;

import com.appchana.books.domainvalue.OnlineStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document(collection = "users")
public class User
{
    @Id
    private String id;
    private String username;
    private String password;
    private Boolean deleted = false;
    private OnlineStatus onlineStatus;

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

    public User(String username, String password, OnlineStatus onlineStatus)
    {
        this.username = username;
        this.password = password;
        this.deleted = false;
        this.onlineStatus = onlineStatus != null ? onlineStatus : OnlineStatus.OFFLINE;
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
}
