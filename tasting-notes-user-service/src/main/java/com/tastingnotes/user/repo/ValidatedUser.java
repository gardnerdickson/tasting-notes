package com.tastingnotes.user.repo;

public class ValidatedUser
{
    private ApiUser user;
    private boolean valid;

    public ValidatedUser()
    {
    }

    public ValidatedUser(ApiUser user, boolean valid)
    {
        this.user = user;
        this.valid = valid;
    }

    public ApiUser getUser()
    {
        return user;
    }

    public boolean isValid()
    {
        return valid;
    }
}
