package com.tastingnotes.service.data;

import java.io.Serializable;

public class Product implements Serializable
{
    private long id;
    private String name;

    public Product()
    {
    }

    public Product(long id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }
}
