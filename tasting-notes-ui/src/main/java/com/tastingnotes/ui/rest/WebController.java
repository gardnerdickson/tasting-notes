package com.tastingnotes.ui.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public Collection<String> getProducts(@RequestParam("keywords") String keywords)
    {
        logger.info("Looking up products for keywords: {}", keywords);
        return Arrays.asList("Black Label", "Highland Park 12", "Glenlivet");
    }

}
