package com.appchana.books.dto;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Date;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthorDTO
{
    private String id;

    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @NotNull(message = "Name can not be null!")
    private String name;

    private String country;

    private String language;

    private String biography;

    private Date birthDate;

    private Boolean deleted = false;


    private AuthorDTO()
    {
    }


    public AuthorDTO(String id, String name, String country, String language, String biography, Date birthDate)
    {
        this.id = id;
        this.name = name;
        this.country = country;
        this.language = language;
        this.biography = biography;
        this.birthDate = birthDate;
    }

    public static AuthorDTOBuilder newBuilder()
    {
        return new AuthorDTOBuilder();
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
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
        private String id;
        private String name;
        private String country;
        private String language;
        private String biography;
        private Date birthDate;


        public AuthorDTOBuilder setId(String id)
        {
            this.id = id;
            return this;
        }


        public AuthorDTOBuilder setName(String name)
        {
            this.name = name;
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
            return new AuthorDTO(id, name, country, language, biography, birthDate);
        }

    }
}
