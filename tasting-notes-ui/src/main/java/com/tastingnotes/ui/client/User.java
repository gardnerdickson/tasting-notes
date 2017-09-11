package com.tastingnotes.ui.client;

public class User
{
    private Long id;
    private String username;
    private char[] password;

    public User()
    {
    }

    public User(Long id, String username, char[] password)
    {
        this.id = id;
        this.username = username;
        this.password = password;
    }

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
