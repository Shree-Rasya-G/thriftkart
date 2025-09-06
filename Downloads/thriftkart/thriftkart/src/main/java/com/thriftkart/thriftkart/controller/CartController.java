package com.thriftkart.thriftkart.controller;

import com.thriftkart.thriftkart.model.Cart;
import com.thriftkart.thriftkart.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    // Add item to cart
    @PostMapping
    public Cart addToCart(@RequestBody Cart cart) {
        return cartService.addToCart(cart);
    }

    // Get all items in the cart
    @GetMapping
    public List<Cart> getAllCartItems() {
        return cartService.getAllCartItems();
    }

    // Remove single cart item
    @DeleteMapping("/{cartId}")
    public String removeItem(@PathVariable Long cartId) {
        cartService.removeItem(cartId);
        return "Cart item removed.";
    }

    // Clear entire cart
    @DeleteMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "Cart cleared.";
    }
}

