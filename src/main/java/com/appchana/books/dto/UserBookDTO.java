package com.appchana.books.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserBookDTO
{
    @JsonIgnore
    private Long userBookId;

    @NotNull(message = "UserId can not be null!")
    private Long userId;

    @NotNull(message = "BookId can not be null!")
    private Long bookId;

    private UserBookDTO()
    {
    }


    public UserBookDTO(Long userBookId, Long userId, Long bookId)
    {
        this.userBookId = userBookId;
        this.userId = userId;
        this.bookId = bookId;
    }


    public static UserBookDTOBuilder newBuilder()
    {
        return new UserBookDTOBuilder();
    }


    @JsonProperty
    public Long getUserBookId()
    {
        return userBookId;
    }

    @JsonProperty
    public Long getUserId()
    {
        return userId;
    }

    public Long getBookId()
    {
        return bookId;
    }


    public static class UserBookDTOBuilder
    {
        private Long userBookId;
        private Long userId;
        private Long bookId;


        public UserBookDTOBuilder setUserBookId(Long userBookId)
        {
            this.userBookId = userBookId;
            return this;
        }


        public UserBookDTOBuilder setUserId(Long userId)
        {
            this.userId = userId;
            return this;
        }


        public UserBookDTOBuilder setBookId(Long bookId)
        {
            this.bookId = bookId;
            return this;
        }


        public UserBookDTO createUserBookDTO()
        {
            return new UserBookDTO(bookId, userId, bookId);
        }

    }
}
