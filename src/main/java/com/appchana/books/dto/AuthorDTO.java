package com.appchana.books.dto;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Date;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorDTO
{
    private Long authorId;

    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @NotNull(message = "Name can not be null!")
    private String name;

    @NotNull(message = "Surname can not be null!")
    private String surname;

    private String country;

    private String language;

    private String biography;

    private Date birthDate;

    private Boolean deleted = false;


    private AuthorDTO()
    {
    }


    public AuthorDTO(Long authorId, String name, String surname, String country, String language, String biography, Date birthDate)
    {
        this.authorId = authorId;
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.language = language;
        this.biography = biography;
        this.birthDate = birthDate;
    }

    public static AuthorDTOBuilder newBuilder()
    {
        return new AuthorDTOBuilder();
    }


    public Long getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    public String getBiography() {
        return biography;
    }

    public Date getBirthDate() {
        return birthDate;
    }


    public static class AuthorDTOBuilder
    {
        private Long authorId;
        private String name;
        private String surname;
        private String country;
        private String language;
        private String biography;
        private Date birthDate;


        public AuthorDTOBuilder setAuthorId(Long authorId)
        {
            this.authorId = authorId;
            return this;
        }


        public AuthorDTOBuilder setName(String name)
        {
            this.name = name;
            return this;
        }


        public AuthorDTOBuilder setSurname(String surname)
        {
            this.surname = surname;
            return this;
        }


        public AuthorDTOBuilder setCountry(String country)
        {
            this.country = country;
            return this;
        }


        public AuthorDTOBuilder setLanguage(String language)
        {
            this.language = language;
            return this;
        }


        public AuthorDTOBuilder setBiography(String biography)
        {
            this.biography = biography;
            return this;
        }


        public AuthorDTOBuilder setBirthDate(Date birthDate)
        {
            this.birthDate = birthDate;
            return this;
        }


        public AuthorDTO createAuthorDTO()
        {
            return new AuthorDTO(authorId, name, surname, country, language, biography, birthDate);
        }

    }
}
