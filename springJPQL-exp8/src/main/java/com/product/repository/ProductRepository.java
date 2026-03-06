package com.product.repository;

import com.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Derived Query Method
    List<Product> findByCategory(String category);

    // Derived Query Method
    List<Product> findByPriceBetween(double min, double max);

    // JPQL query - sorted by price
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> getProductsSortedByPrice();

    // JPQL query - products above price
    @Query("SELECT p FROM Product p WHERE p.price > ?1")
    List<Product> getProductsAbovePrice(double price);

    // JPQL query - products by category
    @Query("SELECT p FROM Product p WHERE p.category = ?1")
    List<Product> getProductsByCategory(String category);
}