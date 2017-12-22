package com.appchana.books.controller.mapper;

import com.appchana.books.common.Constants;
import com.appchana.books.dto.BookDTO;
import com.appchana.books.dao.model.Book;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BookMapper
{
    public static Book makeBook(BookDTO bookDTO)
    {
        return new Book(bookDTO.getIsbn10(), bookDTO.getIsbn13(), bookDTO.getTitle(), bookDTO.getSubtitle(), bookDTO.getSynopsis(), bookDTO.getLanguage(), bookDTO.getPageCount(), bookDTO.getAverageRating(), bookDTO.getThumbnail());
    }

    public static Book makeBook(JSONObject jsonObject)
    {
        JSONObject volumeInfo = (JSONObject) jsonObject.get("volumeInfo");

        String title         = (String) volumeInfo.get("title");
        String subtitle      = (String) volumeInfo.get("subtitle");
        String language      = (String) volumeInfo.get("language");
        Integer pageCount    = (Integer) volumeInfo.get("pageCount");
        Double averageRating = (Double) volumeInfo.get("averageRating");

        String isbn10 = null;
        String isbn13 = null;

        JSONArray identifiers = (JSONArray) volumeInfo.get("industryIdentifiers");
        for (int i = 0; i < identifiers.length(); i++) {
            JSONObject identifier = (JSONObject) identifiers.get(i);

            String type = (String) identifier.get("type");
            String value = (String) identifier.get("identifier");

            if(Constants.ISBN_10.equalsIgnoreCase(type)) {
                isbn10 = value;
            }
            if(Constants.ISBN_13.equalsIgnoreCase(type)) {
                isbn13 = value;
            }
        }

        JSONObject searchInfo = (JSONObject) jsonObject.get("searchInfo");
        String synopsis = (String) searchInfo.get("textSnippet");

        JSONObject imageLinks = (JSONObject) volumeInfo.get("imageLinks");
        String thumbnail = (String) imageLinks.get("thumbnail");

        return new Book(isbn10, isbn13, title, subtitle, synopsis, language, pageCount, averageRating, thumbnail);
    }

    public static BookDTO makeBookDTO(Book book)
    {
        BookDTO.BookDTOBuilder bookDTOBuilder = BookDTO.newBuilder()
            .setBookId(book.getBookId())
            .setIsbn10(book.getIsbn10())
            .setIsbn13(book.getIsbn13())
            .setTitle(book.getTitle())
            .setSubtitle(book.getSubtitle())
            .setSynopsis(book.getSynopsis())
            .setLanguage(book.getLanguage())
            .setPageCount(book.getPageCount())
            .setAverageRating(book.getAverageRating())
            .setThumbnail(book.getThumbnail());

        return bookDTOBuilder.createBookDTO();
    }


    public static List<BookDTO> makeBookDTOList(Collection<Book> books)
    {
        return books.stream()
            .map(BookMapper::makeBookDTO)
            .collect(Collectors.toList());
    }
}
