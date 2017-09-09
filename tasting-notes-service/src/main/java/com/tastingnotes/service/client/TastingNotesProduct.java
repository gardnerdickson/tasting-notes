package com.tastingnotes.service.client;


//TODO: explain why 2 POJOs for Product.
public class TastingNotesProduct
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

    public static TastingNotesProduct fromLcboProduct(LcboProduct lcboProduct)
    {
        TastingNotesProduct product = new TastingNotesProduct();
        product.setId(lcboProduct.getId());
        product.setName(lcboProduct.getName());
        product.setTags(lcboProduct.getTags());
        product.setPriceInCents(lcboProduct.getPriceInCents());
        product.setOrigin(lcboProduct.getOrigin());
        product.setPrimaryCategory(lcboProduct.getPrimaryCategory());
        product.setSecondaryCategory(lcboProduct.getSecondaryCategory());
        product.setProducerName(lcboProduct.getProducerName());
        product.setServingSuggestion(lcboProduct.getServingSuggestion());
        product.setTastingNote(lcboProduct.getTastingNote());
        product.setImageThumbUrl(lcboProduct.getImageThumbUrl());
        product.setImageUrl(lcboProduct.getImageUrl());
        product.setVarietal(lcboProduct.getVarietal());
        product.setStyle(lcboProduct.getStyle());
        product.setTertiaryCategory(lcboProduct.getTertiaryCategory());
        return product;
    }

    public long getId()
    {
        return id;
    }

    private void setId(long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    private void setName(String name)
    {
        this.name = name;
    }

    public String getTags()
    {
        return tags;
    }

    private void setTags(String tags)
    {
        this.tags = tags;
    }

    public int getPriceInCents()
    {
        return priceInCents;
    }

    private void setPriceInCents(int priceInCents)
    {
        this.priceInCents = priceInCents;
    }

    public String getOrigin()
    {
        return origin;
    }

    private void setOrigin(String origin)
    {
        this.origin = origin;
    }

    public String getPrimaryCategory()
    {
        return primaryCategory;
    }

    private void setPrimaryCategory(String primaryCategory)
    {
        this.primaryCategory = primaryCategory;
    }

    public String getSecondaryCategory()
    {
        return secondaryCategory;
    }

    private void setSecondaryCategory(String secondaryCategory)
    {
        this.secondaryCategory = secondaryCategory;
    }

    public String getProducerName()
    {
        return producerName;
    }

    private void setProducerName(String producerName)
    {
        this.producerName = producerName;
    }

    public String getServingSuggestion()
    {
        return servingSuggestion;
    }

    private void setServingSuggestion(String servingSuggestion)
    {
        this.servingSuggestion = servingSuggestion;
    }

    public String getTastingNote()
    {
        return tastingNote;
    }

    private void setTastingNote(String tastingNote)
    {
        this.tastingNote = tastingNote;
    }

    public String getImageThumbUrl()
    {
        return imageThumbUrl;
    }

    private void setImageThumbUrl(String imageThumbUrl)
    {
        this.imageThumbUrl = imageThumbUrl;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }

    private void setImageUrl(String imageUrl)
    {
        this.imageUrl = imageUrl;
    }

    public String getVarietal()
    {
        return varietal;
    }

    private void setVarietal(String varietal)
    {
        this.varietal = varietal;
    }

    public String getStyle()
    {
        return style;
    }

    private void setStyle(String style)
    {
        this.style = style;
    }

    public String getTertiaryCategory()
    {
        return tertiaryCategory;
    }

    private void setTertiaryCategory(String tertiaryCategory)
    {
        this.tertiaryCategory = tertiaryCategory;
    }
}
