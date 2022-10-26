package com.example.wishlistproject.Models;

public class Wish {
    public Wish(String id, String url, String wishlistId, int reserved, String reservedTo, String productTitle, double productPrice) {
        this.id = id;
        this.productImageURL = url;
        this.wishlistId = wishlistId;
        this.reserved = reserved;
        this.reservedTo = reservedTo;
        this.productTitle = productTitle;
        this.productPrice = productPrice;
    }
    private String id;
    private String productImageURL;
    private String wishlistId;
    private int reserved;
    private String reservedTo;
    private String productTitle;
    private double productPrice;

    public String getWishlistId() {
        return wishlistId;
    }

    public int getReserved() {
        return reserved;
    }

    public String getReservedTo() {
        return reservedTo;
    }

    public String getId() {
        return id;
    }


    public String getProductTitle() {
        return productTitle;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductImageURL() {
        return productImageURL;
    }
}