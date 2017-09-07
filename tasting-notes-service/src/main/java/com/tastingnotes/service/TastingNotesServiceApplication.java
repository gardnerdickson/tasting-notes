package com.tastingnotes.service;

import com.tastingnotes.service.http.ProductsClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.URISyntaxException;

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

    private static final String TOKEN = "MDoxNTExOTA0YS05MjljLTExZTctODJlYi01YjlhOWQ1OTE0ZTY6STVGbTJJOHV5ckt4VGlkYWxjbXBYZUkwa2xDN0N5UFVGY2ln";

    @Bean
    public ProductsClient productsClient() throws URISyntaxException
    {
        String url = lcboHost + productsPath;
        return new ProductsClient(url, TOKEN);
    }
}
