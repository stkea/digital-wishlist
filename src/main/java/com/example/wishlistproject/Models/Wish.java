package com.example.wishlistproject.Models;

public class Wish {
    public Wish(String id) {
        this.id = id;
    }
    private final String id;
    private String productTitle;
    private double productPrice;
    private String productImageURL;

    public String getId() {
        return id;
    }

}
