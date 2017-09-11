package com.tastingnotes.ui.client;

// TODO: don't want to include password here.
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
