package com.thriftkart.thriftkart.repository;

import com.thriftkart.thriftkart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
