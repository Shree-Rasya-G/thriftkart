package com.thriftkart.thriftkart.service;

import com.thriftkart.thriftkart.model.Cart;
import com.thriftkart.thriftkart.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepo;

    public CartService(CartRepository cartRepo) {
        this.cartRepo = cartRepo;
    }

    public Cart addToCart(Cart cart) {
        return cartRepo.save(cart);
    }

    public List<Cart> getAllCartItems() {
        return cartRepo.findAll();
    }

    public void removeItem(Long cartId) {
        cartRepo.deleteById(cartId);
    }

    public void clearCart() {
        cartRepo.deleteAll();
    }
}
