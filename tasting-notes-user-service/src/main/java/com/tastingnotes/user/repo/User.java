package com.tastingnotes.user.repo;

import javax.persistence.*;

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String username;

    private byte[] password;

    public User()
    {
    }

    public User(String username, byte[] password)
    {
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

    public byte[] getPassword()
    {
        return password;
    }
}
