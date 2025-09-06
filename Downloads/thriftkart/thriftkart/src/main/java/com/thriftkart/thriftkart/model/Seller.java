package com.thriftkart.thriftkart.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sellers")
public class Seller {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shopName;
    private String username;
    private String password;

    public Seller() {}
    public Seller(String shopName, String username, String password) {
        this.shopName = shopName;
        this.username = username;
        this.password = password;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
  public String getShopName()
  {
	  return shopName;
  }
  public void setShopName(String shopName)
  {
	  this.shopName = shopName;
  }
    public String getUsername()
    {
    	return username;}
    public void setUsername(String username)
    {
    	this.username = username;
    }
    public String getPassword()
    {
    	return password;
    }
    public void setPassword(String password)
    {
    	this.password = password;
    }

 }