package org.arcserve.productservice.cache.services;

public interface ICacheService <T> {


    void save(String key, T value);

    // Additional methods can be defined here as needed, such as:
     T get(String key);

     void delete(String key);

     boolean exists(String key);

}
