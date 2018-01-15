package com.appchana.books.googlebooks;

import com.appchana.books.common.Constants;
import com.appchana.books.dao.model.Author;
import com.appchana.books.domainvalue.ConditionType;
import com.appchana.books.util.JsonReader;
import com.appchana.books.dao.model.Book;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivanmolera on 21/12/2017.
 */
public class GoogleBooksAPIService {

    public static JSONObject searchBookByIsbn(String isbn) throws IOException {
        String url = Constants.GOOGLEBOOKS_API_QUERY_VOLUME_URL + Constants.GOOGLEBOOKS_API_ISBN_PARAM + isbn + Constants.GOOGLEBOOKS_API_VOLUME_BASIC_INFO;
        return JsonReader.readJsonFromUrl(url);
    }

    public static JSONObject searchBookByGoogleBooksId(String googleBooksId) throws IOException {
        String url = Constants.GOOGLEBOOKS_API_SINGLE_VOLUME_URL + googleBooksId + Constants.GOOGLEBOOKS_API_KEY_PARAM + Constants.GOOGLEBOOKS_API_VOLUME_EXTENDED_INFO;
        return JsonReader.readJsonFromUrl(url);
    }

    public static Book parseBookWithBasicInfo(JSONObject jsonObject)
    {
        String googleBooksId  = (String) jsonObject.get("id");

        JSONObject volumeInfo = (JSONObject) jsonObject.get("volumeInfo");

        String title          = (String) volumeInfo.get("title");

        return new Book(googleBooksId, title);
    }

    public static Book parseBook(JSONObject jsonObject)
    {
        String googleBooksId  = (String) jsonObject.get("id");

        JSONObject volumeInfo = (JSONObject) jsonObject.get("volumeInfo");

        String title = (String) volumeInfo.get("title");
        String subtitle = null;
        if(volumeInfo.has("subtitle")) {
            subtitle = (String) volumeInfo.get("subtitle");
        }
        String description = null;
        if(volumeInfo.has("description")) {
            description = (String) volumeInfo.get("description");
            if(description.length() > 250) {
                description = description.substring(0, 247) + "...";
            }
        }
        String language = null;
        if(volumeInfo.has("language")) {
            language = (String) volumeInfo.get("language");
        }
        Integer pageCount = null;
        if(volumeInfo.has("pageCount")) {
            pageCount = (Integer) volumeInfo.get("pageCount");
        }
        Double averageRating = null;
        if(volumeInfo.has("averageRating")) {
            averageRating = (Double) volumeInfo.get("averageRating");
        }

        String isbn10 = null;
        String isbn13 = null;

        if(volumeInfo.has("industryIdentifiers")) {
            JSONArray identifiers = (JSONArray) volumeInfo.get("industryIdentifiers");
            for (int i = 0; i < identifiers.length(); i++) {
                JSONObject identifier = (JSONObject) identifiers.get(i);

                String type = (String) identifier.get("type");
                String value = (String) identifier.get("identifier");

                if (Constants.ISBN_10.equalsIgnoreCase(type)) {
                    isbn10 = value;
                }
                if (Constants.ISBN_13.equalsIgnoreCase(type)) {
                    isbn13 = value;
                }
            }
        }

        String cover = null;
        if(volumeInfo.has("imageLinks")) {
            JSONObject imageLinks = (JSONObject) volumeInfo.get("imageLinks");
            cover = (String) imageLinks.get("thumbnail");
        }

        Book book = new Book(googleBooksId, isbn10, isbn13, title, subtitle, description, language, pageCount, averageRating, cover, ConditionType.NEW, null, null, null);

        return book;
    }

    public static List<Author> parseAuthors(JSONObject volumeInfo)
    {
        List<Author> authors = new ArrayList<Author>();
        if(volumeInfo.has("authors")) {
            JSONArray jsonObjectAuthors = (JSONArray) volumeInfo.get("authors");
            String authorName = (String) jsonObjectAuthors.get(0);
            Author author = new Author(authorName, authorName);
            authors.add(author);
        }
        return authors;
    }
}