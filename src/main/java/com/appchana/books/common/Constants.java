package com.appchana.books.common;

/**
 * Created by ivanmolera on 21/12/2017.
 */
public class Constants {

    private Constants() {}

    // https://www.googleapis.com/books/v1/volumes?key=AIzaSyAX_Y1TpTUq2z03C2ZW1bjtcJAhFuZPslY&q=isbn:8408177087
    public static final String GOOGLEBOOKS_API_KEY              = "AIzaSyAX_Y1TpTUq2z03C2ZW1bjtcJAhFuZPslY";
    public static final String GOOGLEBOOKS_API_BASE_URL         = "https://www.googleapis.com/books";
    public static final String GOOGLEBOOKS_API_VERSION          = "v1";
    public static final String GOOGLEBOOKS_API_ACTION_VOLUMES   = "volumes";
    public static final String GOOGLEBOOKS_API_ACTION_USERS     = "users";
    public static final String GOOGLEBOOKS_API_URL              = GOOGLEBOOKS_API_BASE_URL + "/" + GOOGLEBOOKS_API_VERSION;
    public static final String GOOGLEBOOKS_API_KEY_PARAM        = "?key=" + GOOGLEBOOKS_API_KEY;
    public static final String GOOGLEBOOKS_API_QUERY_PARAM      = "&q=";
    public static final String GOOGLEBOOKS_API_ISBN_PARAM       = "isbn:";
    public static final String GOOGLEBOOKS_API_VOLUME_QUERY_URL = GOOGLEBOOKS_API_URL + "/" + GOOGLEBOOKS_API_ACTION_VOLUMES + GOOGLEBOOKS_API_KEY_PARAM + GOOGLEBOOKS_API_QUERY_PARAM;

    public static final String ISBN_10 = "ISBN_10";
    public static final String ISBN_13 = "ISBN_13";
}
