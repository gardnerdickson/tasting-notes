package com.tastingnotes.service.data;

import java.io.Serializable;
import java.util.Set;

public class Note implements Serializable
{
    private String word;
    private Set<Long> productIds;

    public Note()
    {
    }

    public Note(String word, Set<Long> productIds)
    {
        this.word = word;
        this.productIds = productIds;
    }

    public String getWord()
    {
        return word;
    }

    public Set<Long> getProductIds()
    {
        return productIds;
    }
}
