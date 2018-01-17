package com.appchana.books.externalservice;

import com.appchana.books.dao.model.Author;
import com.appchana.books.dao.model.Book;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

/**
 * Created by ivanmolera on 17/01/2018.
 */
public interface ExternalAPIService {

    JSONObject searchBookByIsbn(String isbn) throws IOException;

    Book parseBookWithBasicInfo(JSONObject jsonObject);

    Book parseBook(JSONObject jsonObject);

    List<Author> parseAuthors(JSONObject jsonObject);
}
