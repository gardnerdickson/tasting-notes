package com.tastingnotes.ui.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product
{
    private long id;
    private String name;
    private String tags;
    private int priceInCents;
    private String origin;
    private String primaryCategory;
    private String secondaryCategory;
    private String producerName;
    private String servingSuggestion;
    private String tastingNote;
    private String imageThumbUrl;
    private String imageUrl;
    private String varietal;
    private String style;
    private String tertiaryCategory;

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getTags()
    {
        return tags;
    }

    public int getPriceInCents()
    {
        return priceInCents;
    }

    public String getOrigin()
    {
        return origin;
    }

    public String getPrimaryCategory()
    {
        return primaryCategory;
    }

    public String getSecondaryCategory()
    {
        return secondaryCategory;
    }

    public String getProducerName()
    {
        return producerName;
    }

    public String getServingSuggestion()
    {
        return servingSuggestion;
    }

    public String getTastingNote()
    {
        return tastingNote;
    }

    public String getImageThumbUrl()
    {
        return imageThumbUrl;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    public String getVarietal()
    {
        return varietal;
    }

    public String getStyle()
    {
        return style;
    }

    public String getTertiaryCategory()
    {
        return tertiaryCategory;
    }
}
