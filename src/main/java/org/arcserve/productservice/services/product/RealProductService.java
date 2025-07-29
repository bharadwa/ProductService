package org.arcserve.productservice.services.product;

import org.arcserve.productservice.exceptions.ProductNotFoundException;
import org.arcserve.productservice.models.category.Category;
import org.arcserve.productservice.models.product.Product;
import org.arcserve.productservice.repositories.category.CategoryRepository;
import org.arcserve.productservice.repositories.product.ProductRepository;
import org.arcserve.productservice.repositories.projections.ProductWithTitleAndPrice;
import org.arcserve.productservice.services.cache.ProductCacheService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//for new branch we need to set the upstream repository to the real implementation --set-upstream-repository
@Service("realProductService")
public class RealProductService implements ProductService,IProductServiceExtension {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductCacheService productCacheService;

    public RealProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository,ProductCacheService productCacheService) {
        this.productRepository   = productRepository;
        this.categoryRepository  = categoryRepository;
        this.productCacheService = productCacheService;
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product
     * @return the product with the specified ID
     */
    @Override
    public Product getProductById(Long id) {
       return productCacheService.getProduct(id);
    }

    /**
     * Retrieves all products.
     *
     * @return a list of all products
     */
    @Override
    public List<Product> getAllProducts() {

        productRepository.findDistinctByPrice(10.0);
        return List.of();
    }

    /**
     * Creates a new product.
     *
     * @param product the product to create
     * @return the created product
     */
    @Override
    public Product createProduct(Product product) {

        if (product.getCategory() != null) {
            if (product.getCategory().getId() == null) {
                if (product.getCategory().getValue() == null) {
                    throw new RuntimeException("category value cannot be null");
                }
                Optional<Category> optionalCategory = categoryRepository.findByValue(product.getCategory().getValue());
                if (optionalCategory.isEmpty()) {
                    Category category = categoryRepository.save(product.getCategory());
                    product.setCategory(category);
                } else {
                    product.setCategory(optionalCategory.get());
                }
            }else {
                Optional<Category> optionalCategory = categoryRepository.findById(product.getCategory().getId());
                if (optionalCategory.isEmpty()) {
                    Category category = categoryRepository.save(product.getCategory());
                    product.setCategory(category);
                } else {
                    throw  new RuntimeException("category already exists");
                }
            }
            return  productRepository.save(product);
        } else {
            throw new RuntimeException("category cannot be null");
        }

    }

    @Override
    public Product createProductV2(Product product) {
        ProductWithTitleAndPrice withTitleAndPrice= productRepository.getTitleAndPriceById(1l);
        if(withTitleAndPrice!=null) {
            System.out.println("Title: " + withTitleAndPrice.getTitle());
            System.out.println("Price: " + withTitleAndPrice.getPrice());
        }
        return productRepository.save(product);
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
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new ProductNotFoundException("Product with ID " + id + " not found", "productid", new String[]{id.toString()});
        }
    }

    @Override
    public Page<Product> getAllProductsV2(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size));
    }
}
