package com.appchana.books.dao.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Document(collection = "authors")
public class Author
{
    @Id
    private String id;
    private String name;
    private String surname;
    private String country;
    private String language;
    private String biography;
    private Date birthDate;
    private Boolean deleted = false;

    private Author()
    {
    }

    public Author(String name, String surname)
    {
        this.name = name;
        this.surname = surname;
    }

    public Author(String name, String surname, String country, String language, String biography, Date birthDate)
    {
        this.name = name;
        this.surname = surname;
        this.country = country;
        this.language = language;
        this.biography = biography;
        this.birthDate = birthDate;
        this.deleted = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    @NotNull(message = "Author name can not be null!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @NotNull(message = "Author surname can not be null!")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }


    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


    public Boolean getDeleted() { return deleted; }

    public void setDeleted(Boolean deleted) { this.deleted = deleted; }
}
