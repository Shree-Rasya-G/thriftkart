package com.thriftkart.thriftkart.service;

import com.thriftkart.thriftkart.dto.LoginResponse;
import com.thriftkart.thriftkart.model.User;
import com.thriftkart.thriftkart.model.Seller;
import com.thriftkart.thriftkart.repository.UserRepository;
import com.thriftkart.thriftkart.repository.SellerRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepo;
    private final SellerRepository sellerRepo;

    public AuthService(UserRepository userRepo, SellerRepository sellerRepo) {
        this.userRepo = userRepo;
        this.sellerRepo = sellerRepo;
    }

    public LoginResponse login(String username, String password, String type) {
        if ("user".equalsIgnoreCase(type)) {
            User user = userRepo.findByUsernameIgnoreCase(username);
            if (user != null && user.getPassword().equals(password)) {
                return new LoginResponse("User login successful", user.getId(), user.getUsername(), "user");
            }
        } else if ("seller".equalsIgnoreCase(type)) {
            Seller seller = sellerRepo.findByUsernameIgnoreCase(username);
            if (seller != null && seller.getPassword().equals(password)) {
                return new LoginResponse("Seller login successful", seller.getId(), seller.getUsername(), "seller");
            }
        }
        return new LoginResponse("Invalid credentials", null, null, type);
    }
}
