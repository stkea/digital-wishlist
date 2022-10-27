package com.example.wishlistproject.Models.Wishlist;

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

    public Wishlist(String id){
        this.id = id;
        wishes = new ArrayList<>();
    }

    public Wishlist(){
        wishes = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public List<Wish> getWishes() {
        return wishes;
    }

    public void setWishes(List<Wish> wishes) {
        this.wishes = wishes;
    }

    private String id;
    private String title = "";
    private String creatorName = "";
    private String expiration;
    private List<Wish> wishes;
}
