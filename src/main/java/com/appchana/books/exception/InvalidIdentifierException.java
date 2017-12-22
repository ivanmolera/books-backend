package com.appchana.books.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid or malformed identifier.")
public class InvalidIdentifierException extends Exception
{
    static final long serialVersionUID = -1L;


    public InvalidIdentifierException(String message)
    {
        super(message);
    }

}
