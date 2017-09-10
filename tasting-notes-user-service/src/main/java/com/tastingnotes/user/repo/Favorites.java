package com.tastingnotes.user.repo;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Favorites
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    @ElementCollection(targetClass = Long.class)
    private Set<Long> productIds;

    public Favorites()
    {
    }

    public Favorites(Long userId, Set<Long> productIds)
    {
        this.userId = userId;
        this.productIds = productIds;
    }

    public Long getUserId()
    {
        return userId;
    }

    public Long getId()
    {
        return id;
    }

    public Set<Long> getProductIds()
    {
        return productIds;
    }
}
