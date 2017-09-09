package com.tastingnotes.ui.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

public class ProductClient
{
    private final Logger logger = LoggerFactory.getLogger(ProductClient.class);

    private URI uri;

    private RestTemplate client;

    public ProductClient(String url) throws URISyntaxException
    {
        this.uri = new URI(url);
        this.client = new RestTemplateBuilder().build();
    }

    public Collection<Product> getProductsFromTastingNotes(String notes)
    {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUri(uri).queryParam("notes", notes);
        ParameterizedTypeReference<Collection<Product>> typeRef = new ParameterizedTypeReference<Collection<Product>>()
        {
        };

        ResponseEntity<Collection<Product>> response = client.exchange(builder.build().encode().toString(), HttpMethod.GET, null, typeRef);
        return response.getBody();
    }
}
