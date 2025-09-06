package com.thriftkart.thriftkart.dto;

public class LoginResponse {

    private String message;   // e.g., "User login successful" or "Invalid credentials"
    private Long id;          // userId or sellerId (null if login fails)
    private String username;  // username (null if login fails)
    private String type;      // "user" or "seller"

    // Constructor
    public LoginResponse(String message, Long id, String username, String type) {
        this.message = message;
        this.id = id;
        this.username = username;
        this.type = type;
    }

    // Getters & Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
