package com.tastingnotes.ui;


import com.tastingnotes.ui.client.ProductClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@SpringBootApplication
public class TastingNotesUIApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(TastingNotesUIApplication.class);
    }

    @Value("${service.host}")
    private String serviceHost;

    @Value("${service.context.product}")
    private String productContext;

    @Bean
    ProductClient productClient() throws URISyntaxException
    {
        return new ProductClient(serviceHost + productContext);
    }

}

