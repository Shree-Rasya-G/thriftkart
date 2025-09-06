package com.thriftkart.thriftkart.repository;

import com.thriftkart.thriftkart.model.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    Seller findByUsernameIgnoreCase(String username);

  
}
