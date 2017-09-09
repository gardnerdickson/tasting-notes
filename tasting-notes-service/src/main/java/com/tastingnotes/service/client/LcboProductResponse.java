package com.tastingnotes.service.client;

public class LcboProductResponse<T>
{
    private int status;

    private String message;

    private LcboProductPager pager;

    private T result;

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public LcboProductPager getPager()
    {
        return pager;
    }

    public void setPager(LcboProductPager pager)
    {
        this.pager = pager;
    }

    public T getResult()
    {
        return result;
    }

    public void setResult(T result)
    {
        this.result = result;
    }
}
