package com.tastingnotes.service.client;

class PagedRequestException extends RuntimeException
{
    public PagedRequestException()
    {
    }

    public PagedRequestException(String message)
    {
        super(message);
    }

    public PagedRequestException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public PagedRequestException(Throwable cause)
    {
        super(cause);
    }
}
