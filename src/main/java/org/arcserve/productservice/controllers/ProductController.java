package org.arcserve.productservice.controllers;

import lombok.Getter;
import org.arcserve.productservice.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/products")
@RestController
public class ProductController {

    // get a product by id
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") String productId) {
        return null;
    }
    // get all products
    @GetMapping
    public  ArrayList<Product> getAllProducts() {
        return new ArrayList<Product>();
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
        System.out.println("Replacing product with id: " + productId);
    }

    @PostMapping
    public void createProduct(@RequestBody Product product ) {

    }
}
