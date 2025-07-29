package org.arcserve.productservice.services.cache;

import org.arcserve.productservice.models.product.Product;

public interface ProductCacheService {

    void saveProduct(Product value);

    Product getProduct(Long productId);

    void deleteProduct(Long productId);

    boolean productExists(Long productId);

    Product updateProduct(Product updatedProduct) throws Exception;

}

