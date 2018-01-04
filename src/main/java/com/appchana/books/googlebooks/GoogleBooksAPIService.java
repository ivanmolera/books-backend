package com.appchana.books.googlebooks;

import com.appchana.books.common.Constants;
import com.appchana.books.common.JsonReader;
import com.appchana.books.dao.model.Book;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

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

        // TODO: get author info

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

        return new Book(googleBooksId, isbn10, isbn13, title, subtitle, description, language, pageCount, averageRating, cover);
    }
}


