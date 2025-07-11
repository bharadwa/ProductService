package org.arcserve.productservice.controllers;

import org.arcserve.productservice.models.Product;
import org.arcserve.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {


    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // get a product by id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long productId) {
        return new ResponseEntity<>(productService.getProductById(productId),
                HttpStatus.OK
        );
    }

    // get all products
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") String productId) {
        // Logic to delete a product by id
        System.out.println("Deleting product with id: " + productId);
    }

    @PatchMapping("/{id}")
    public void updateProduct(@PathVariable("id") String productId, @RequestBody Product product) {

    }

    @PutMapping("/{id}")
    public void replaceProduct(@PathVariable("id") String productId, @RequestBody Product product) {
        // Logic to replace a product by id
        // System.out.println("Replacing product with id: " + productId);
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {

    }
}
