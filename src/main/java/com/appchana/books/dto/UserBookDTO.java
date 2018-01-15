package com.appchana.books.dto;

import com.appchana.books.domainvalue.ConditionType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserBookDTO
{
    private Long userBookId;
    private ConditionType conditionType;
    private String picture01;
    private String picture02;
    private String picture03;
    private UserDTO user;
    private BookDTO book;

    private UserBookDTO()
    {
    }


    public UserBookDTO(Long userBookId, UserDTO user, BookDTO book, ConditionType conditionType, String picture01, String picture02, String picture03)
    {
        this.userBookId = userBookId;
        this.user = user;
        this.book = book;
        this.conditionType = conditionType;
        this.picture01 = picture01;
        this.picture02 = picture02;
        this.picture03 = picture03;
    }


    public static UserBookDTOBuilder newBuilder()
    {
        return new UserBookDTOBuilder();
    }


    public Long getUserBookId()
    {
        return userBookId;
    }

    @JsonIgnore
    public UserDTO getUser()
    {
        return user;
    }

    @NotNull(message = "Book can not be null!")
    public BookDTO getBook()
    {
        return book;
    }

    @NotNull(message = "ConditionType can not be null!")
    public ConditionType getConditionType() {
        return conditionType;
    }

    public String getPicture01() {
        return picture01;
    }

    public String getPicture02() {
        return picture02;
    }

    public String getPicture03() {
        return picture03;
    }


    public static class UserBookDTOBuilder
    {
        private Long userBookId;
        private UserDTO user;
        private BookDTO book;
        private ConditionType conditionType;
        private String picture01;
        private String picture02;
        private String picture03;


        public UserBookDTOBuilder setUserBookId(Long userBookId)
        {
            this.userBookId = userBookId;
            return this;
        }


        public UserBookDTOBuilder setUser(UserDTO user)
        {
            this.user = user;
            return this;
        }


        public UserBookDTOBuilder setBook(BookDTO book)
        {
            this.book = book;
            return this;
        }


        public UserBookDTOBuilder setConditionType(ConditionType conditionType)
        {
            this.conditionType = conditionType;
            return this;
        }


        public UserBookDTOBuilder setPicture01(String picture01)
        {
            this.picture01 = picture01;
            return this;
        }


        public UserBookDTOBuilder setPicture02(String picture02)
        {
            this.picture02 = picture02;
            return this;
        }


        public UserBookDTOBuilder setPicture03(String picture03)
        {
            this.picture03 = picture03;
            return this;
        }


        public UserBookDTO createUserBookDTO()
        {
            return new UserBookDTO(userBookId, user, book, conditionType, picture01, picture02, picture03);
        }

    }
}
