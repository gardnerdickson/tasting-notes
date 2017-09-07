package com.tastingnotes.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class TastingNotesConfigApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(TastingNotesConfigApplication.class, args);
    }
}
