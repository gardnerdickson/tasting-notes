package com.tastingnotes.user;

import com.tastingnotes.user.repo.Favorites;
import com.tastingnotes.user.repo.FavoritesRepository;
import com.tastingnotes.user.repo.User;
import com.tastingnotes.user.repo.UserRepository;
import com.tastingnotes.user.util.PasswordHasher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

@SpringBootApplication
public class TastingNotesUserApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(TastingNotesUserApplication.class);
    }

    @Bean
    public CommandLineRunner demo(UserRepository userRepo, FavoritesRepository favRepo)
    {
        return (args) -> {
            userRepo.save(new User("cloud", PasswordHasher.hash("midgar".toCharArray())));
            userRepo.save(new User("yukon", PasswordHasher.hash("river".toCharArray())));
        };
    }

}
