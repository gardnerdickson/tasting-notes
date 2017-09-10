package com.tastingnotes.user.repo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface FavoritesRepository extends CrudRepository<Favorites, Long>
{
    List<Favorites> findByUserId(Long userId);
}
