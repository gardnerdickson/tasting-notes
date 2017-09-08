package com.tastingnotes.service.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponse
{
    private int status;

    private String message;

    private ProductPager pager;

    private Collection<Product> result;

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

    public ProductPager getPager()
    {
        return pager;
    }

    public void setPager(ProductPager pager)
    {
        this.pager = pager;
    }

    public Collection<Product> getResult()
    {
        return result;
    }

    public void setResult(Collection<Product> result)
    {
        this.result = result;
    }
}
