package com.appchana.books.controller.mapper;

import com.appchana.books.dao.model.Author;
import com.appchana.books.dto.AuthorDTO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorMapper
{
    public static Author makeAuthor(AuthorDTO authorDTO)
    {
        return new Author(authorDTO.getName(), authorDTO.getSurname(), authorDTO.getCountry(), authorDTO.getLanguage(), authorDTO.getBiography(), authorDTO.getBirthDate());
    }

    public static AuthorDTO makeAuthorDTO(Author author)
    {
        AuthorDTO.AuthorDTOBuilder authorDTOBuilder = AuthorDTO.newBuilder()
            .setAuthorId(author.getAuthorId())
            .setName(author.getName())
            .setSurname(author.getSurname())
            .setCountry(author.getCountry())
            .setLanguage(author.getLanguage())
            .setBiography(author.getBiography())
            .setBirthDate(author.getBirthDate());

        return authorDTOBuilder.createAuthorDTO();
    }


    public static List<AuthorDTO> makeAuthorDTOList(Collection<Author> authors)
    {
        return authors.stream()
            .map(AuthorMapper::makeAuthorDTO)
            .collect(Collectors.toList());
    }
}
