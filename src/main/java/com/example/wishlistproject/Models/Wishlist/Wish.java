package com.example.wishlistproject.Models.Wishlist;

public class Wish {
    public Wish(String id, String url, String wishlistId, int reserved, String productTitle, double productPrice) {
        this.id = id;
        this.productImageURL = url;
        this.wishlistId = wishlistId;
        this.reserved = reserved;
        this.productTitle = productTitle;
        this.productPrice = productPrice;
    }

    public Wish(String id){
        this.id = id;
    }

    public Wish(){

    }

    private String id;
    private String productImageURL;
    private String wishlistId;
    private int reserved;
    private String productTitle;
    private double productPrice;

    public String getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(String id){
        this.wishlistId = id;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    public void reserve(){
        reserved = 1;
    }

    public void unReserve(){
        reserved = 0;
    }


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

    public void setId(String id) {
        this.id = id;
    }

}