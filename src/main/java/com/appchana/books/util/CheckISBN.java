package com.appchana.books.util;

import com.appchana.books.common.Constants;
import com.appchana.books.exception.InvalidIdentifierException;
import com.appchana.books.dao.model.Book;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class CheckISBN
{

    private static final Log LOG = LogFactory.getLog(CheckISBN.class);

    public static String getISBNType(String isbn) throws InvalidIdentifierException
    {
        String isbnType = null;
        if(isbn != null && isbn.length() == 10) {
            isbnType = Constants.ISBN_10;
        }
        else if(isbn != null && isbn.length() == 13) {
            isbnType = Constants.ISBN_13;
        }
        return isbnType;
    }

    public static String getISBN(Book book) throws InvalidIdentifierException
    {
        String isbn10 = book.getIsbn10();
        String isbn13 = book.getIsbn13();
        String isbn = null;

        if(getISBNType(isbn10) != null && Constants.ISBN_10.equals(getISBNType(isbn10)))  {
            isbn = isbn10;
        }
        else if(getISBNType(isbn13) != null && Constants.ISBN_13.equals(getISBNType(isbn13)))  {
            isbn = isbn13;
        }
        return isbn;
    }
}
