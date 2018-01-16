package com.appchana.books.controller.mapper;

import com.appchana.books.dao.model.Author;
import com.appchana.books.dto.AuthorDTO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorMapper
{
    public static Author makeAuthor(AuthorDTO authorDTO)
    {
        return new Author(authorDTO.getName(), authorDTO.getCountry(), authorDTO.getLanguage(), authorDTO.getBiography(), authorDTO.getBirthDate());
    }

    public static AuthorDTO makeAuthorDTO(Author author)
    {
        AuthorDTO.AuthorDTOBuilder authorDTOBuilder = AuthorDTO.newBuilder()
            .setId(author.getId())
            .setName(author.getName())
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

    public static List<Author> makeAuthorList(Collection<AuthorDTO> authors)
    {
        if(authors != null) {
            return authors.stream()
                    .map(AuthorMapper::makeAuthor)
                    .collect(Collectors.toList());
        }
        return new ArrayList<Author>();
    }
}
