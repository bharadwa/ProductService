package org.arcserve.productservice.services.product;

import org.arcserve.productservice.dtos.FakeStoreProductDTO;
import org.arcserve.productservice.exceptions.ProductNotFoundException;
import org.arcserve.productservice.models.Category;
import org.arcserve.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {


    private final RestTemplate restTemplate;


    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product
     * @return the product with the specified ID
     */
    @Override
    public Product getProductById(Long id) {

        throw new ProductNotFoundException("product not found", "200202", new String [] {String.valueOf(id)});
        /*FakeStoreProductDTO dto = restTemplate.getForObject
                ("https://fakestoreapi.com/products/" + id, FakeStoreProductDTO.class);
        assert dto != null;
        return convertTOProductDTO(dto);*/
    }


    /**
     * Retrieves all products.
     *
     * @return a list of all products
     */
    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] dtos= restTemplate.getForObject
                ("https://fakestoreapi.com/products/" ,FakeStoreProductDTO[].class);
        assert dtos != null;
        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDTO dto : dtos) {
            Product product = convertTOProductDTO(dto);
            // Here you can add the product to a list or process it as needed
            // For example, you could return a list of products
            products.add(product);
        }
        return products;
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

    private Product convertTOProductDTO(FakeStoreProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setId(dto.getId());
        product.setDescription(dto.getDescription());
        product.setTitle(dto.getTitle());
        product.setPrice(dto.getPrice());
        product.setCategory(new Category());
        product.getCategory().setValue(dto.getCategory());
        product.setImage(dto.getImage());
        return product;
    }
}
