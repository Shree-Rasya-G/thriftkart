package com.thriftkart.thriftkart.service;

import com.thriftkart.thriftkart.model.Cart;
import com.thriftkart.thriftkart.model.Order;
import com.thriftkart.thriftkart.model.Product;
import com.thriftkart.thriftkart.repository.CartRepository;
import com.thriftkart.thriftkart.repository.OrderRepository;
import com.thriftkart.thriftkart.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository,
                        CartRepository cartRepository,
                        ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    // Place an order and remove product from cart
    public Order placeOrder(Order order) {
        // Fetch product to calculate price and update stock
        Product product = productRepository.findById(order.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Set price
        order.setPrice((int)(product.getPrice() * order.getQuantity()));

           // Set order status
        order.setStatus("PLACED");

        // Save order
        Order savedOrder = orderRepository.save(order);

        // Remove item(s) from cart based on productId
        List<Cart> carts = cartRepository.findAll();
        carts.stream()
                .filter(c -> c.getProductId().equals(order.getProductId()))
                .forEach(cartRepository::delete);

        // Decrease product stock
        product.setStock(product.getStock() - order.getQuantity());
        productRepository.save(product);

        return savedOrder;
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
