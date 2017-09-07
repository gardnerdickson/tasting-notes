package com.tastingnotes.service.http;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

class TokenAuthRequestInterceptor implements ClientHttpRequestInterceptor
{
    private final String token;

    TokenAuthRequestInterceptor(String token)
    {
        this.token = token;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException
    {
        httpRequest.getHeaders().add("Authorization", "Token " + (token));
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}
