package com.appchana.books.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO
{
    private String id;
    private String username;
    private String password;

    private UserDTO()
    {
    }


    private UserDTO(String id, String username, String password)
    {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public static UserDTOBuilder newBuilder()
    {
        return new UserDTOBuilder();
    }


    public String getiId()
    {
        return id;
    }

    @NotNull(message = "Username can not be null!")
    public String getUsername()
    {
        return username;
    }

    @JsonIgnore
    @NotNull(message = "Password can not be null!")
    public String getPassword()
    {
        return password;
    }


    public static class UserDTOBuilder
    {
        private String id;
        private String username;
        private String password;


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


        public UserDTO createUserDTO()
        {
            return new UserDTO(id, username, password);
        }

    }
}
