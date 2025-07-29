package org.arcserve.productservice.cache.services;

import org.arcserve.productservice.cache.utils.RedisOperationUtils;
import org.arcserve.productservice.utils.DAOModelConvertor;

public abstract class BaseCacheServiceImpl<T> implements  ICacheService<T> {


    private final RedisOperationUtils redisOperationUtils;

    private final Class<T> type;

    private static final String CACHE_PREFIX = "ps-version-01";

    public BaseCacheServiceImpl(RedisOperationUtils redisOperationUtils, Class<T> type) {
        this.redisOperationUtils = redisOperationUtils;
        this.type = type;
    }


    protected String generateKey(Object key) {
        return CACHE_PREFIX + "-" +type.getSimpleName()+"-" +key;
    }

    @Override
    public void save(String key, T value) {
        redisOperationUtils.save(key, value);
    }

    @Override
    public T get(String key) {
        return DAOModelConvertor.convert(redisOperationUtils.get(key), type);
    }

    @Override
    public void delete(String key) {
        redisOperationUtils.delete(key);
    }

    @Override
    public boolean exists(String key) {
        return redisOperationUtils.get(key) != null;
    }
}
