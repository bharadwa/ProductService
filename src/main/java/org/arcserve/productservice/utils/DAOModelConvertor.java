package org.arcserve.productservice.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;



public class DAOModelConvertor {


    /**
     * Converts an object of one type to another type.
     *
     * @param source the source object to convert
     * @param targetClass the class of the target type
     * @param <T> the type of the target object
     * @return an instance of the target type with properties copied from the source object
     */
    public static <T> T convert (Object source, Class<T> targetClass) {
        if (source == null) {
            return null;
        }
        try {
            T target = targetClass.getDeclaredConstructor().newInstance();
            // Assuming a method to copy properties from source to target
            // This could be done using libraries like Apache Commons BeanUtils or Spring BeanUtils
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (Exception e) {
            throw new RuntimeException("Conversion failed", e);
        }
    }


}
