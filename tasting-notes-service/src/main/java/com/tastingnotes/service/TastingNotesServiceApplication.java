package com.tastingnotes.service;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tastingnotes.service.client.GoogleNlpClient;
import com.tastingnotes.service.client.LcboProductsClient;
import com.tastingnotes.service.data.NoteRepository;
import com.tastingnotes.service.data.ProductRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

@SpringBootApplication
@EnableScheduling
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

    @Value("file://#{systemProperties['auth.lcboapi.key']}")
    private Resource lcboTokenResource;


    @Bean
    JedisConnectionFactory jedisConnectionFactory()
    {
        return new JedisConnectionFactory();
    }

    @Bean
    public NoteRepository noteRepository()
    {
        RedisTemplate<String, Long> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericToStringSerializer<>(Long.class));
        template.afterPropertiesSet();
        return new NoteRepository(template);
    }

    @Bean
    public ProductRepository productRepository()
    {
        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return new ProductRepository(template);
    }


    @Bean
    LcboProductsClient lcboProductsClient() throws URISyntaxException, IOException
    {
        String url = lcboHost + productsPath;
        return new LcboProductsClient(url, lcboToken());
    }

    @Bean
    GoogleNlpClient nlpClient()
    {
        return new GoogleNlpClient();
    }

    @Bean
    String lcboToken() throws IOException
    {
        return new String(Files.readAllBytes(lcboTokenResource.getFile().toPath()));
    }

    @Bean
    Module javaTimeModule()
    {
        return new JavaTimeModule();
    }
}
