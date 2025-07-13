package org.arcserve.productservice.services.product;

import org.arcserve.productservice.exceptions.ProductNotFoundException;
import org.arcserve.productservice.models.Product;
import org.arcserve.productservice.repositories.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("realProductService")
public class RealProductService implements ProductService {

     private final ProductRepository productRepository;

     public RealProductService(ProductRepository productRepository) {
         this.productRepository = productRepository;
     }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product
     * @return the product with the specified ID
     */
    @Override
    public Product getProductById(Long id) {
        Optional<Product> product= productRepository.findById(id);
        if(product.isEmpty()) {
            throw  new ProductNotFoundException("Product with ID " + id + " not found");
        }else {
            return product.get();
        }

    }

    /**
     * Retrieves all products.
     *
     * @return a list of all products
     */
    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    /**
     * Creates a new product.
     *
     * @param product the product to create
     * @return the created product
     */
    @Override
    public void createProduct(Product product) {

    }

    /**
     * Updates an existing product.
     *
     * @param id      the ID of the product to update
     * @param product the updated product data
     * @return the updated product
     */
    @Override
    public void updateProduct(Long id, Product product) {

    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     */
    @Override
    public void deleteProduct(Long id) {

    }
}
