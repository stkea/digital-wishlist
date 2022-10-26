package com.example.wishlistproject.Models;

public class Wish {
    public Wish(String id) {
        this.id = id;
    }
    private final String id;
    private Product product;

    public String getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
