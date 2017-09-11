package com.tastingnotes.ui.client;


public class ApiUser
{
    private Long id;
    private String username;

    public ApiUser()
    {
    }

    public ApiUser(Long id, String username)
    {
        this.id = id;
        this.username = username;
    }

    public Long getId()
    {
        return id;
    }

    public String getUsername()
    {
        return username;
    }
}
