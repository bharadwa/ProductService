package org.arcserve.productservice.cache.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class RedisOperationUtils {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisOperationUtils(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void save(String key, Object value) {
        redisTemplate.opsForValue().set(key,  value,43200L, TimeUnit.SECONDS);;
    }

    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public void update(String key, Object value) {
        if (redisTemplate.hasKey(key)) {
            redisTemplate.opsForValue().set(key, value,43200L, TimeUnit.SECONDS);
        } else {
            throw new IllegalArgumentException("Key does not exist in Redis: " + key);
        }
    }

    public void exists(String key) {
        if (!redisTemplate.hasKey(key)) {
            throw new IllegalArgumentException("Key does not exist in Redis: " + key);
        }
    }

    public void hSave(String key, String hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    public Object hGet(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    public void hDelete(String key, String hashKey) {
        redisTemplate.opsForHash().delete(key, hashKey);
    }

    public void hSaveInBatch(String keys, Map<String,Object> values) {
        redisTemplate.opsForHash().putAll(keys, values);
    }

    public Map<Object, Object> hGetEntries(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

}
