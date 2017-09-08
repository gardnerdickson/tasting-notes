package com.tastingnotes.service.rest;

import com.tastingnotes.service.client.Product;
import com.tastingnotes.service.client.ProductsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ProductRestController
{
    private final Logger logger = LoggerFactory.getLogger(ProductRestController.class);

    @Autowired
    private ProductsClient productsClient;


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

}
