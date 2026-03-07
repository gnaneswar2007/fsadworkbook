package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    // URL: http://localhost:8080/products/category/Electronics
    // Fetch products by category
    @GetMapping("/category/{category}")
    public List<Product> getProductsByCategory(@PathVariable String category) {
        return repository.findByCategory(category);
    }

    // URL: http://localhost:8080/products/filter?min=100&max=600
    // Fetch products within a price range
    @GetMapping("/filter")
    public List<Product> getProductsByPriceRange(@RequestParam double min,
                                                 @RequestParam double max) {
        return repository.findByPriceBetween(min, max);
    }

    // URL: http://localhost:8080/products/sorted
    // Fetch products sorted by price
    @GetMapping("/sorted")
    public List<Product> getSortedProducts() {
        return repository.getProductsSortedByPrice();
    }

    // URL: http://localhost:8080/products/expensive/300
    // Fetch products above given price
    @GetMapping("/expensive/{price}")
    public List<Product> getExpensiveProducts(@PathVariable double price) {
        return repository.getProductsAbovePrice(price);
    }
}