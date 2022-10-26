package com.example.wishlistproject.Repository.CRUD.Get;

import com.example.wishlistproject.Models.Wish;
import com.example.wishlistproject.Models.Wishlist;

import java.util.List;

public interface IGetter {
    Wishlist getWishlistById(String id);
    List<Wishlist> getAllWishlist();
    Wish getWishById(String id);
    List<Wish> getAllWishes();

}
