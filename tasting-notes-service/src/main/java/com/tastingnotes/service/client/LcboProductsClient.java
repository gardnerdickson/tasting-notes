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
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

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

    public List<LcboProduct> getProducts()
    {
        return getProducts(null);
    }

    public List<LcboProduct> getProducts(String query)
    {
        PagedGetRequest<LcboProduct> pagedRequest = new PagedGetRequest<>(getRequestFunction(query));
        return pagedRequest.getAll();
    }


    public Iterator<LcboProduct> getProductIterator()
    {
        return getProductIterator(null);
    }

    public Iterator<LcboProduct> getProductIterator(String query)
    {
        PagedGetRequest<LcboProduct> pagedRequest = new PagedGetRequest<>(getRequestFunction(query));
        return pagedRequest.iterator();
    }

    public LcboProduct getProduct(Long id)
    {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUri(uri).pathSegment(id.toString());
        ResponseEntity<LcboProductSingleResponse> response = client.exchange(builder.build().encode().toString(), HttpMethod.GET, null, LcboProductSingleResponse.class);
        return response.getBody().getResult();
    }


    private Function<Integer, ResponseEntity<List<LcboProduct>>> getRequestFunction(String query)
    {
        return (pageNum) -> {
            UriComponentsBuilder builder = UriComponentsBuilder.fromUri(uri).queryParam("page", pageNum);
            if (query != null)
            {
                builder = builder.queryParam("q", query);
            }
            logger.info("Executing GET request for products, page " + pageNum);
            ResponseEntity<LcboProductCollectionResponse> response = client.exchange(builder.build().encode().toString(), HttpMethod.GET, null, LcboProductCollectionResponse.class);
            return new ResponseEntity<>(response.getBody().getResult(), response.getStatusCode());
        };
    }
}
