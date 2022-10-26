package com.example.wishlistproject.Models;

import java.util.ArrayList;
import java.util.List;

public class Wishlist {
    public Wishlist(String id, String title, String creator, String expiration) {
        this.id = id;
        this.title = title;
        this.creatorName = creator;
        this.expiration = expiration;
        wishes = new ArrayList<>();
    }
    private final String id;
    private String title;
    private String creatorName;
    private String expiration;

    public String getExpiration() {
        return expiration;
    }

    public String getTitle() {
        return title;
    }

    public String getCreatorName() {
        return creatorName;
    }

    private List<Wish> wishes;

    public String getId() {
        return id;
    }

    public List<Wish> getWishes() {
        return wishes;
    }

    public void setWishes(List<Wish> wishes) {
        this.wishes = wishes;
    }
}
