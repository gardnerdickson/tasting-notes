package com.tastingnotes.ui.rest;

import com.tastingnotes.ui.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

@RestController
public class WebController
{
    private final Logger logger = LoggerFactory.getLogger(WebController.class);

    private static final String SESSION_USER = "currentUser";

    @Autowired
    private ProductClient productClient;

    @Autowired
    private UserClient userClient;

    @RequestMapping(method = RequestMethod.GET, value = "/products")
    public ResponseEntity<Collection<Product>> getProducts(@RequestParam("keywords") String keywords)
    {
        try
        {
            Collection<Product> products = productClient.getProductsFromTastingNotes(keywords);
            return new ResponseEntity<Collection<Product>>(products, HttpStatus.OK);
        }
        catch (ClientException e)
        {
            return new ResponseEntity<>(e.getHttpStatus());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ResponseEntity<ApiUser> getUserByUsername(@RequestParam("username") String username)
    {
        ResponseEntity<ApiUser> response;
        User user;
        try
        {
            user = userClient.getUser(username);
            response = new ResponseEntity<>(new ApiUser(user.getId(), user.getUsername()), HttpStatus.OK);
        }
        catch (ClientException e)
        {
            response = new ResponseEntity<>(e.getHttpStatus());
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/currentUser")
    public ResponseEntity<ApiUser> getCurrentUser(HttpServletRequest request)
    {
        String username = (String)request.getSession().getAttribute(SESSION_USER);
        if (username == null)
        {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        ResponseEntity<ApiUser> response;
        try
        {
            User user = userClient.getUser(username);
            response = new ResponseEntity<>(new ApiUser(user.getId(), user.getUsername()), HttpStatus.OK);
        }
        catch (ClientException e)
        {
            response = new ResponseEntity<>(e.getHttpStatus());
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/favorites")
    public ResponseEntity<Void> addFavorite(@RequestBody ProductId productId, HttpServletRequest request)
    {
        String username = (String)request.getSession().getAttribute(SESSION_USER);
        if (username == null)
        {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        ResponseEntity<Void> response;
        try
        {
            User user = userClient.getUser(username);
            userClient.addUserFavorite(user.getId(), productId);
            response = new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (ClientException e)
        {
            response = new ResponseEntity<>(e.getHttpStatus());
        }
        return response;
    }


    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public ResponseEntity<Void> createUser(@RequestBody User user, HttpServletRequest request)
    {
        ResponseEntity<Void> response;
        try
        {
            userClient.createUser(user);
            request.getSession().setAttribute(SESSION_USER, user.getUsername());
            response = new ResponseEntity<>(HttpStatus.OK);
        }
        catch (ClientException e)
        {
            response = new ResponseEntity<>(e.getHttpStatus());
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/favorites")
    public ResponseEntity<Collection<Product>> getCurrentUserFavorites(HttpServletRequest request)
    {
        String username = (String)request.getSession().getAttribute(SESSION_USER);
        if (username == null)
        {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        try
        {
            User user = userClient.getUser(username);
            List<Long> productIds = userClient.getUserFavorites(user.getId());
            if (productIds.isEmpty())
            {
                return new ResponseEntity<>(HttpStatus.OK);
            }
            Collection<Product> products = productClient.getProductsByIds(productIds);
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
        catch (ClientException e)
        {
            return new ResponseEntity<>(e.getHttpStatus());
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<Void> loginUser(@RequestBody User user, HttpServletRequest request)
    {
        ValidatedUser validatedUser;
        try
        {
            validatedUser = userClient.validateUser(user);
            if (validatedUser.isValid())
            {
                logger.info("Validated user '{}'", user.getUsername());
                request.getSession().setAttribute(SESSION_USER, user.getUsername());

                return new ResponseEntity<>(HttpStatus.OK);
            }
            logger.info("Failed to validate user '{}'", user.getUsername());
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        catch (ClientException e)
        {
            return new ResponseEntity<>(e.getHttpStatus());
        }
    }

}

