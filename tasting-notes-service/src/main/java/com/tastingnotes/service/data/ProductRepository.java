package com.tastingnotes.service.data;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository
{
    private static final String KEY = "product";

    private ValueOperations<String, String> valueOperations;

    public ProductRepository(RedisTemplate<String, String> redisTemplate)
    {
        this.valueOperations = redisTemplate.opsForValue();
    }

    public void saveProduct(Product product)
    {
        valueOperations.append(key(product.getId()), product.getName());
    }

    public String findProduct(long id)
    {
        return valueOperations.get(key(id));
    }

    public boolean hasProduct(long id)
    {
        return findProduct(id) != null;
    }


    private static String key(long id)
    {
        return KEY + ":" + id;
    }
}
