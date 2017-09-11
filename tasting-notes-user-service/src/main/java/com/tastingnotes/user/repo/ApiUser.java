package com.tastingnotes.user.repo;

// TODO: need this users for POST requests. Password is not hashed at this point.
public class ApiUser
{
    private Long id;
    private String username;
    private char[] password;

    public Long getId()
    {
        return id;
    }

    public String getUsername()
    {
        return username;
    }

    public char[] getPassword()
    {
        return password;
    }
}
