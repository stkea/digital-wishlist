package com.example.wishlistproject.Models;

public class Wish {
    public Wish(String id, String wishlistId) {
        this.id = id;
        this.wishlistId = wishlistId;
    }
    private final String id;
    private String productTitle;
    private double productPrice;
    private String productImageURL;

    private final String wishlistId;

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductImageURL() {
        return productImageURL;
    }

    public void setProductImageURL(String productImageURL) {
        this.productImageURL = productImageURL;
    }

    public String getId() {
        return id;
    }

    public String getWishlistId() {
        return wishlistId;
    }
}
