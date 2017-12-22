package com.appchana.books.googlebooks;

import com.appchana.books.common.Constants;
import com.appchana.books.common.JsonReader;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by ivanmolera on 21/12/2017.
 */
public class GoogleBooksAPIService {

    public static JSONObject searchBookByIsbn(String isbn) throws IOException {
        String url = Constants.GOOGLEBOOKS_API_VOLUME_QUERY_URL + Constants.GOOGLEBOOKS_API_ISBN_PARAM + isbn;
        return JsonReader.readJsonFromUrl(url);
    }
}


