package com.example.wishlistproject.Models.Sharing;

public class ShareToken {
    public ShareToken(String id, String wishlistId, String tokenValue) {
        this.wishlistId = wishlistId;
        this.tokenValue = tokenValue;
        this.id = id;
    }

    public String getWishlistId() {
        return wishlistId;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public String getId() {
        return id;
    }

    private String wishlistId;
    private String tokenValue;
    private String id;
}
