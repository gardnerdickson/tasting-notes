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

    @Value("file://#{systemProperties['auth.lcboapi.key']}")
    private Resource lcboTokenResource;

    @Value("${redis.host}")
    private String redisHost;

    @Value("${redis.port}")
    private String redisPort;

    @Value("file://#{systemProperties['auth.redis.key']}")
    private Resource redisTokenResource;


    @Bean
    JedisConnectionFactory jedisConnectionFactory() throws IOException
    {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName(redisHost);
        connectionFactory.setPort(Integer.parseInt(redisPort));
        connectionFactory.setPassword(redisToken());
        return connectionFactory;
    }

    @Bean
    public NoteRepository noteRepository() throws IOException
    {
        RedisTemplate<String, Long> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new GenericToStringSerializer<>(Long.class));
        template.afterPropertiesSet();
        return new NoteRepository(template);
    }

    @Bean
    public ProductRepository productRepository() throws IOException
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
        return new LcboProductsClient(lcboHost, lcboToken());
    }

    @Bean
    GoogleNlpClient nlpClient()
    {
        return new GoogleNlpClient();
    }

    @Bean
    String lcboToken() throws IOException
    {
        return new String(Files.readAllBytes(lcboTokenResource.getFile().toPath()), "UTF-8").trim();
    }

    @Bean
    String redisToken() throws IOException
    {

        return new String(Files.readAllBytes(redisTokenResource.getFile().toPath()), "UTF-8").trim();
    }

    @Bean
    Module javaTimeModule()
    {
        return new JavaTimeModule();
    }
}
