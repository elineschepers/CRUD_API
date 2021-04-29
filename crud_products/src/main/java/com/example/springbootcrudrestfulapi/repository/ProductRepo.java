package com.example.springbootcrudrestfulapi.repository;

import com.example.springbootcrudrestfulapi.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
