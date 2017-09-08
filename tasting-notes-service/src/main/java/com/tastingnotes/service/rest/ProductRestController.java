package com.tastingnotes.service.rest;

import com.tastingnotes.service.client.NaturalLanguageProcessingClient;
import com.tastingnotes.service.client.Product;
import com.tastingnotes.service.client.ProductsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

@RestController
public class ProductRestController
{
    private final Logger logger = LoggerFactory.getLogger(ProductRestController.class);

    @Autowired
    private ProductsClient productsClient;

    @Autowired
    private NaturalLanguageProcessingClient languageClient;


    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String test()
    {
        return "This seems to be working.";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public Collection<Product> getProducts(@RequestParam(required = false, value = "query") String query) throws Exception
    {
        return productsClient.getProducts(query);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/notes/{id}")
    public List<String> getNotes(@PathVariable(value = "id") Long productId) throws IOException
    {
        Product lcboProduct = productsClient.getProduct(productId);
        List<String> entities = languageClient.getLanguageEntities(lcboProduct.getTastingNote());

        return entities;
    }


}
