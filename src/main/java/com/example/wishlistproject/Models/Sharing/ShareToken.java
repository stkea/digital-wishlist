package com.example.wishlistproject.Models.Sharing;

public class ShareToken {
    public ShareToken(String id, String wishlistId, String tokenLink, String tokenValue) {
        this.id = id;
        this.wishlistId = wishlistId;
        this.tokenLink = tokenLink;
        this.tokenValue = tokenValue;
    }

    public String getWishlistId() {
        return wishlistId;
    }

    public String getTokenLink() {
        return tokenLink;
    }

    public String getId() {
        return id;
    }

    public String getTokenKey() {
        return tokenValue;
    }

    private String wishlistId;
    private String tokenLink;
    private String tokenValue;
    private String id;
}
