package com.appchana.books.dto;

import com.appchana.books.dao.model.Contact;
import com.appchana.books.domainvalue.OnlineStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO
{
    private String id;
    private String username;
    private String password;
    private OnlineStatus onlineStatus;
    private ContactDTO contact;

    private List<String> books;

    private UserDTO()
    {
    }


    private UserDTO(String id, String username, String password, OnlineStatus onlineStatus, ContactDTO contact, List<String> books)
    {
        this.id = id;
        this.username = username;
        this.password = password;
        this.onlineStatus = onlineStatus;
        this.contact = contact;
        this.books = books;
    }


    public static UserDTOBuilder newBuilder()
    {
        return new UserDTOBuilder();
    }


    public String getId()
    {
        return id;
    }

    @NotNull(message = "Username can not be null!")
    public String getUsername()
    {
        return username;
    }

    //@JsonIgnore
    @NotNull(message = "Password can not be null!")
    public String getPassword()
    {
        return password;
    }

    public OnlineStatus getOnlineStatus() {
        return onlineStatus;
    }

    public ContactDTO getContact() {
        return contact;
    }

    public List<String> getBooks() {
        return books;
    }

    public static class UserDTOBuilder
    {
        private String id;
        private String username;
        private String password;
        private OnlineStatus onlineStatus;
        private ContactDTO contact;
        private List<String> books;


        public UserDTOBuilder setId(String id)
        {
            this.id = id;
            return this;
        }


        public UserDTOBuilder setUsername(String username)
        {
            this.username = username;
            return this;
        }


        public UserDTOBuilder setPassword(String password)
        {
            this.password = password;
            return this;
        }


        public UserDTOBuilder setOnlineStatus(OnlineStatus onlineStatus)
        {
            this.onlineStatus = onlineStatus;
            return this;
        }


        public UserDTOBuilder setContact(ContactDTO contact)
        {
            this.contact = contact;
            return this;
        }


        public UserDTOBuilder setBooks(List<String> books)
        {
            this.books = books;
            return this;
        }


        public UserDTO createUserDTO()
        {
            return new UserDTO(id, username, password, onlineStatus, contact, books);
        }

    }
}
