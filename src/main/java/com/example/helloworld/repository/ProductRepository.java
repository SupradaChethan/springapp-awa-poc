package com.example.helloworld.repository;

import com.example.helloworld.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Custom query methods can be added here
    List<Product> findByNameContainingIgnoreCase(String name);

    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
}
