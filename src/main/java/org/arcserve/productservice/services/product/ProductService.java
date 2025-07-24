package org.arcserve.productservice.services.product;
import org.arcserve.productservice.models.product.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product
     * @return the product with the specified ID
     */
    Product getProductById(Long id);

    /**
     * Retrieves all products.
     *
     * @return a list of all products
     */
    List<Product> getAllProducts();

    /**
     * Creates a new product.
     *
     * @param product the product to create
     * @return the created product
     */
    Product createProduct(Product  product);

    /**
     * Updates an existing product.
     *
     * @param id      the ID of the product to update
     * @param product the updated product data
     * @return the updated product
     */
    void updateProduct(Long id, Product product);

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     */
    void deleteProduct(Long id);

    Page<Product> getAllProductsV2(int page, int size);
}
