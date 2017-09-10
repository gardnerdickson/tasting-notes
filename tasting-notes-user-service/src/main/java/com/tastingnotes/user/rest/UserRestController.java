package com.tastingnotes.user.rest;

import com.tastingnotes.user.repo.*;
import com.tastingnotes.user.util.PasswordHasher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController
{
    private final Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FavoritesRepository favoritesRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getAllUsers()
    {
        List<User> users = new ArrayList<>();
        for(User user: userRepository.findAll())
        {
            users.add(user);
        }
        return users;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}/favorites")
    public List<Favorites> getFavorites(@PathVariable("id") Long userId)
    {
        logger.info("Retrieving favorite product for user with ID {}", userId);
        return favoritesRepository.findByUserId(userId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void createUser(@RequestBody ApiUser apiUser) throws NoSuchAlgorithmException
    {
        logger.info("Creating new user with username '{}'", apiUser.getUsername());
        userRepository.save(new User(apiUser.getUsername(), PasswordHasher.hash(apiUser.getPassword())));
    }
}
