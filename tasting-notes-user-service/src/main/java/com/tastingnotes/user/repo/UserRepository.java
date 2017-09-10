package com.tastingnotes.user.repo;


import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long>
{
    List<User> findByUsername(String username);
}
