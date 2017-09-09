package com.tastingnotes.ui.rest;

import com.tastingnotes.ui.client.Product;
import com.tastingnotes.ui.client.ProductClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

@RestController
public class WebController
{
    private final Logger logger = LoggerFactory.getLogger(WebController.class);

    @Autowired
    private ProductClient productClient;

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public Collection<Product> getProducts(@RequestParam("keywords") String keywords)
    {
        return productClient.getProductsFromTastingNotes(keywords);
    }

}
