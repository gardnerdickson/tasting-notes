package com.tastingnotes.service.data;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class NoteRepository
{
    private static final String KEY = "note";

    private SetOperations<String, Long> setOperations;

    public NoteRepository(RedisTemplate<String, Long> redisTemplate)
    {
        this.setOperations = redisTemplate.opsForSet();
    }

    public void saveNote(Note note)
    {
        setOperations.add(key(note.getWord()), note.getProductIds().toArray(new Long[]{}));
    }

    public Set<Long> findNote(String word)
    {
        return setOperations.members(key(word));
    }

    private static String key(String word)
    {
        return KEY + ":" + word.replaceAll(" ", "_");
    }
}
