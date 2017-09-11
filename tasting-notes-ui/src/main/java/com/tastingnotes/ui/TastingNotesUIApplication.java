package com.tastingnotes.ui;


import com.tastingnotes.ui.client.ProductClient;
import com.tastingnotes.ui.client.UserClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URISyntaxException;

@SpringBootApplication
public class TastingNotesUIApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(TastingNotesUIApplication.class);
    }

    @Value("${product.host}")
    private String productHost;

    @Value("${user.host}")
    private String userHost;

    @Bean
    ProductClient productClient() throws URISyntaxException
    {
        return new ProductClient(productHost);
    }

    @Bean
    UserClient userClient() throws URISyntaxException
    {
        return new UserClient(userHost);
    }

//    @Bean
//    WebUserDetailsService userDetailsService()
//    {
//        return new WebUserDetailsService();
//    }



}

