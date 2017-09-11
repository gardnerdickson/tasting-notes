package com.tastingnotes.user.repo;

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
