package com.tastingnotes.ui.client;

import org.springframework.http.HttpStatus;

public class ClientException extends Exception
{
    private final HttpStatus httpStatus;

    public ClientException(HttpStatus httpStatus)
    {
        this.httpStatus = httpStatus;
    }

    public ClientException(HttpStatus httpStatus, String message)
    {
        super(message);
        this.httpStatus = httpStatus;
    }

    public ClientException(HttpStatus httpStatus, String message, Throwable cause)
    {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public ClientException(HttpStatus httpStatus, Throwable cause)
    {
        super(cause);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus()
    {
        return httpStatus;
    }
}
