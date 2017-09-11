package com.tastingnotes.ui.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductClient
{
    private final Logger logger = LoggerFactory.getLogger(ProductClient.class);

    private static final String PRODUCTS_CONTEXT = "/products";

    private String host;

    private RestTemplate client;

    public ProductClient(String host) throws URISyntaxException
    {
        this.host = host;
        this.client = new RestTemplateBuilder().build();
    }

    public Collection<Product> getProductsFromTastingNotes(String notes) throws ClientException
    {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(host + PRODUCTS_CONTEXT)
                .queryParam("notes", notes);
        ParameterizedTypeReference<Collection<Product>> typeRef = new ParameterizedTypeReference<Collection<Product>>()
        {
        };

        ResponseEntity<Collection<Product>> response = client.exchange(builder.build().encode().toString(), HttpMethod.GET, null, typeRef);
        if (response.getStatusCode() != HttpStatus.OK)
        {
            throw new ClientException(response.getStatusCode(), "Failed to retreive products for tasting notes: " + notes);
        }

        return response.getBody();
    }

    public Collection<Product> getProductsByIds(Collection<Long> productIds) throws ClientException
    {
        List<Product> products = new ArrayList<>();
        for (Long id : productIds)
        {
            UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(host + PRODUCTS_CONTEXT + "/" + id);
            ResponseEntity<Product> response = client.exchange(builder.build().encode().toString(), HttpMethod.GET, null, Product.class);
            if (response.getStatusCode() != HttpStatus.OK)
            {
                throw new ClientException(response.getStatusCode(), "Failed to retrieve product with ID " + id);
            }
            products.add(response.getBody());
        }
        return products;
    }
}
