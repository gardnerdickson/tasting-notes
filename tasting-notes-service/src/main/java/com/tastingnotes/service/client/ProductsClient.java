package com.tastingnotes.service.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

public class ProductsClient
{
    private final Logger logger = LoggerFactory.getLogger(ProductsClient.class);

    private URI uri;

    private RestTemplate client;

    public ProductsClient(String url, String token) throws URISyntaxException
    {
        if (token == null)
        {
            throw new NullPointerException("token must not be null");
        }
        this.uri = new URI(url);
        this.client = new RestTemplateBuilder().additionalInterceptors(new TokenAuthRequestInterceptor(token)).build();
    }

    public String getProducts(String query) throws Exception
    {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUri(uri).queryParam("q", query);

        ResponseEntity<String> response = client.exchange(builder.build().encode().toString(), HttpMethod.GET, null, String.class);
        return response.getBody();
    }
}
