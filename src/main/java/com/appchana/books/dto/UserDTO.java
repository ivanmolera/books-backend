package com.appchana.books.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO
{
    @JsonIgnore
    private Long userId;

    @NotNull(message = "Username can not be null!")
    private String username;

    @NotNull(message = "Password can not be null!")
    private String password;

    private UserDTO()
    {
    }


    private UserDTO(Long userId, String username, String password)
    {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }


    public static UserDTOBuilder newBuilder()
    {
        return new UserDTOBuilder();
    }


    @JsonProperty
    public Long getUserId()
    {
        return userId;
    }


    public String getUsername()
    {
        return username;
    }


    public String getPassword()
    {
        return password;
    }


    public static class UserDTOBuilder
    {
        private Long userId;
        private String username;
        private String password;


        public UserDTOBuilder setUserId(Long userId)
        {
            this.userId = userId;
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
            return new UserDTO(userId, username, password);
        }

    }
}
