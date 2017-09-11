package com.tastingnotes.user.rest;

import com.tastingnotes.user.repo.*;
import com.tastingnotes.user.util.PasswordHasher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class UserRestController
{
    private final Logger logger = LoggerFactory.getLogger(UserRestController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FavoritesRepository favoritesRepository;


    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getAllUsers(@RequestParam(required = false, value = "username") String username)
    {
        List<User> users;
        if (username != null)
        {
            logger.info("Retrieving user with username '{}'", username);
            return userRepository.findByUsername(username);
        }
        else
        {
            logger.info("Retrieving all users");
            users = new ArrayList<>();
            for (User user: userRepository.findAll())
            {
                users.add(user);
            }
        }
        return users;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}/favorites")
    public ResponseEntity<Set<Long>> getFavorites(@PathVariable("id") Long userId)
    {
        logger.info("Retrieving favorite product for user with ID {}", userId);
        List<Favorites> favoritesList = favoritesRepository.findByUserId(userId);
        if (favoritesList.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(favoritesList.get(0).getProductIds(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "users/{id}/favorites")
    public ResponseEntity<Void> addFavorite(@RequestBody ProductId productId, @PathVariable("id") long userId)
    {
        logger.info("Adding product ID {} to favorites for user with ID {}", productId.getId(), userId);
        List<Favorites> favoritesList = favoritesRepository.findByUserId(userId);
        Favorites userFavorites = favoritesList.get(0);
        userFavorites.getProductIds().add(productId.getId());
        favoritesRepository.save(userFavorites);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void createUser(@RequestBody ApiUser apiUser) throws NoSuchAlgorithmException
    {
        logger.info("Creating new user with username '{}'", apiUser.getUsername());
        userRepository.save(new User(apiUser.getUsername(), PasswordHasher.hash(apiUser.getPassword())));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/validate")
    public ValidatedUser validateUser(@RequestBody ApiUser user) throws NoSuchAlgorithmException, UserNotFoundException
    {
        List<User> storedUsers = userRepository.findByUsername(user.getUsername());
        if (storedUsers.isEmpty())
        {
            throw new UserNotFoundException("Failed to find user with username " + user.getUsername());
        }

        User storedUser = storedUsers.get(0);
        byte[] hashedIncomingPassword = PasswordHasher.hash(user.getPassword());
        if (new String(hashedIncomingPassword).equals(new String(storedUser.getPassword())))
        {
            logger.info("Username and password combination is valid");
            return new ValidatedUser(user, true);
        }
        else
        {
            logger.info("Username and password combination is invalid");
            return new ValidatedUser(user, false);
        }
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String catchAll(Exception e)
    {
        return e.getMessage();
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String userNotFound(UserNotFoundException e)
    {
        return e.getMessage();
    }

}

class ProductId
{
    private Long id;

    public Long getId()
    {
        return id;
    }
}