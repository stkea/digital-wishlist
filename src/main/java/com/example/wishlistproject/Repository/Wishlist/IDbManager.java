package com.example.wishlistproject.Repository.Wishlist;

import com.example.wishlistproject.Models.Wishlist.Wish;
import com.example.wishlistproject.Models.Wishlist.Wishlist;

import java.util.List;

public interface IDbManager {
    boolean addWishlist(Wishlist wishlist);
    Wishlist getWishlistById(String id);
    boolean removeWishlistById(String id);
    boolean updateWishlist(Wishlist wishlist);
    List<Wish> getAllWishes(String wishlistId);
    boolean addWish(String wishlistId, Wish w);
    Wish getWishById(String id);
    List<Wishlist> getAllWishlist();
    boolean removeWish(String id);
    boolean updateWish(Wish wish);
    boolean handleReserve(String wishId);
}
