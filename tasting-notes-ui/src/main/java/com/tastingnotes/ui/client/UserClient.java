package com.tastingnotes.ui.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URISyntaxException;
import java.util.List;

public class UserClient
{
    private final Logger logger = LoggerFactory.getLogger(UserClient.class);

    private static final String USERS_CONTEXT = "/users";
    private static final String VALIDATE_CONTEXT = "/users/validate";
    private static final String FAVORITES_CONTEXT = "/users/{id}/favorites";

    private String host;

    private RestTemplate client;

    public UserClient(String host) throws URISyntaxException
    {
        this.host = host;
        this.client = new RestTemplateBuilder().build();
    }

    public User getUser(String username) throws ClientException
    {
        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(host + USERS_CONTEXT)
                .queryParam("username", username);

        ParameterizedTypeReference<List<User>> typeRef = new ParameterizedTypeReference<List<User>>()
        {
        };

        ResponseEntity<List<User>> response = client.exchange(builder.build().encode().toString(), HttpMethod.GET, null, typeRef);
        if (response.getStatusCode() != HttpStatus.OK)
        {
            throw new ClientException(response.getStatusCode(), "Failed to retrieve user.");
        }
        return response.getBody().get(0);
    }

    public void createUser(User user) throws ClientException
    {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(host + USERS_CONTEXT);
        RequestEntity<User> request = new RequestEntity<>(user, HttpMethod.POST, builder.build().toUri());

        ResponseEntity<Void> response = client.exchange(request, Void.class);
        if (response.getStatusCode() != HttpStatus.CREATED)
        {
            throw new ClientException(response.getStatusCode(), "Failed to create user.");
        }
    }

    public List<Long> getUserFavorites(Long userId) throws ClientException
    {

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(host + FAVORITES_CONTEXT.replace("{id}", userId.toString()));
        ParameterizedTypeReference<List<Long>> typeRef = new ParameterizedTypeReference<List<Long>>()
        {
        };

        String url = builder.build().encode().toString();
        ResponseEntity<List<Long>> response = client.exchange(url, HttpMethod.GET, null, typeRef);
        if (response.getStatusCode() != HttpStatus.OK && response.getStatusCode() != HttpStatus.NO_CONTENT)
        {
            throw new ClientException(response.getStatusCode(), "Failed to retrieve user.");
        }
        return response.getBody();
    }

    public void addUserFavorite(Long userId, ProductId productId) throws ClientException
    {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(host + FAVORITES_CONTEXT.replace("{id}", userId.toString()));
        RequestEntity<ProductId> request = new RequestEntity<>(productId, HttpMethod.POST, builder.build().toUri());
        ResponseEntity<Void> response = client.exchange(request, Void.class);
        if (response.getStatusCode() != HttpStatus.CREATED)
        {
            throw new ClientException(response.getStatusCode(), "Failed POST new user favorite.");
        }
    }

    public ValidatedUser validateUser(User user) throws ClientException
    {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(host + VALIDATE_CONTEXT);
        RequestEntity<User> request = new RequestEntity<>(user, HttpMethod.POST, builder.build().toUri());

        ResponseEntity<ValidatedUser> response = client.exchange(request, ValidatedUser.class);
        if (response.getStatusCode() != HttpStatus.OK)
        {
            throw new ClientException(response.getStatusCode(), "Failed to validate user.");
        }
        return response.getBody();
    }
}
