package com.tastingnotes.service;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tastingnotes.service.client.ProductsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

@SpringBootApplication
public class TastingNotesServiceApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(TastingNotesServiceApplication.class, args);
    }


    @Value("${lcboapi.host}")
    private String lcboHost;

    @Value("${lcboapi.context.product}")
    private String productsPath;

    @Value("classpath:auth/lcbo-api-key")
    private Resource lcboTokenResource;

    @Bean
    public ProductsClient productsClient() throws URISyntaxException, IOException
    {
        String url = lcboHost + productsPath;
        return new ProductsClient(url, lcboToken());
    }

    @Bean
    String lcboToken() throws IOException
    {
        return new String(Files.readAllBytes(lcboTokenResource.getFile().toPath()));
    }

    @Bean
    public Module javaTimeModule()
    {
        return new JavaTimeModule();
    }
}
