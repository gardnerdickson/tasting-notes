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
import java.util.Collection;

public class LcboProductsClient
{
    private final Logger logger = LoggerFactory.getLogger(LcboProductsClient.class);

    private URI uri;

    private RestTemplate client;

    public LcboProductsClient(String url, String token) throws URISyntaxException
    {
        if (token == null)
        {
            throw new NullPointerException("token must not be null");
        }
        this.uri = new URI(url);
        this.client = new RestTemplateBuilder().additionalInterceptors(new TokenAuthRequestInterceptor(token)).build();
    }

    public Collection<LcboProduct> getProducts(String query) throws Exception
    {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUri(uri).queryParam("q", query);

        ResponseEntity<LcboProductCollectionResponse> response = client.exchange(builder.build().encode().toString(), HttpMethod.GET, null, LcboProductCollectionResponse.class);
        return response.getBody().getResult();
    }

    public LcboProduct getProduct(Long id)
    {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUri(uri).pathSegment(id.toString());

        ResponseEntity<LcboProductSingleResponse> response = client.exchange(builder.build().encode().toString(), HttpMethod.GET, null, LcboProductSingleResponse.class);
        return response.getBody().getResult();
    }
}
