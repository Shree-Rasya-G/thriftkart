package com.thriftkart.thriftkart.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")   
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;     // who placed the order
    private Long productId;  // which product
    private int quantity;
    private int price;
    private String status;

    public Order() {}

    public Order(Long userId, Long productId, int quantity, int price) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;  
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

	
	public String getStatus() {
	    return status;
	}

	public void setStatus(String status) {
	    this.status = status;
	}

	
}
