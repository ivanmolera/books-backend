package com.appchana.books.dao.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table(
    name = "authors", uniqueConstraints = {
        @UniqueConstraint(name = "uc_authors_name", columnNames = {"name", "surname"})
    }
)
public class Author
{
    private Long authorId;
    private ZonedDateTime dateCreated = ZonedDateTime.now();
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


    @Id
    @GeneratedValue
    @Column(name = "author_id")
    public Long getAuthorId() { return authorId; }

    public void setAuthorId(Long authorId) { this.authorId = authorId; }

    @JsonIgnore
    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }


    @Column(nullable = false)
    @NotNull(message = "Author name can not be null!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Column(nullable = false)
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


    @Column(nullable = false)
    public Boolean getDeleted() { return deleted; }

    public void setDeleted(Boolean deleted) { this.deleted = deleted; }
}
