package com.product.service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findByCategory(String category) {
        return repository.findByCategory(category);
    }

    public List<Product> findByPriceRange(double min, double max) {
        return repository.findByPriceBetween(min, max);
    }

    public List<Product> getSortedProducts() {
        return repository.getProductsSortedByPrice();
    }

    public List<Product> getExpensiveProducts(double price) {
        return repository.getProductsAbovePrice(price);
    }
}