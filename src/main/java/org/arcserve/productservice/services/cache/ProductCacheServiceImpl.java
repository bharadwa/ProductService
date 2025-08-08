package org.arcserve.productservice.services.cache;

import org.arcserve.productservice.cache.services.BaseCacheServiceImpl;
import org.arcserve.productservice.cache.utils.RedisOperationUtils;
import org.arcserve.productservice.exceptions.ProductNotFoundException;
import org.arcserve.productservice.models.product.Product;
import org.arcserve.productservice.repositories.product.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductCacheServiceImpl extends BaseCacheServiceImpl<Product> implements  ProductCacheService {

    private final ProductRepository productRepository;

    public ProductCacheServiceImpl(RedisOperationUtils redisOperationUtils, ProductRepository productRepository) {
        super(redisOperationUtils,Product.class);
        this.productRepository =productRepository;
    }

    @Override
    public void saveProduct(Product value) {
        productRepository.save(value);
    }

    @Override
    public Product getProduct(Long productId) {
        String key = generateKey(productId);
        Product product = get(key);
        if (product == null) {
            product = productRepository.findById(productId).orElseThrow(() -> new ProductNotFoundException("product not found with id: " + productId));
            if (product != null) {
                save(key, product);
            }
        }
        return product;
    }

    @Override
    public void deleteProduct(Long productId) {
        String key = generateKey(productId);
        delete(key);
        // Also delete from the database
        Product product = productRepository.findById(productId).orElse(null);
        if(product != null){
            product.setDeleted(true); // Assuming you have a deleted flag
            productRepository.save(product);
        }

        productRepository.deleteById(productId);
    }

    @Override
    public boolean productExists(Long productId) {
        String key = generateKey(productId);
        return exists(key) || productRepository.existsById(productId);
    }

    @Override
    public Product updateProduct(Product updatedProduct) throws Exception {
       String key = generateKey(updatedProduct.getId());
        if (exists(key)) {
            super.delete(key);
        }
        return productRepository.save(updatedProduct);
    }
}
