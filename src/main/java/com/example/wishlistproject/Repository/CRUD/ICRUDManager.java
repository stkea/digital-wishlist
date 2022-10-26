package com.example.wishlistproject.Repository.CRUD;

import com.example.wishlistproject.Models.Wish;
import com.example.wishlistproject.Models.Wishlist;
import com.example.wishlistproject.Repository.CRUD.Add.IAdder;
import com.example.wishlistproject.Repository.CRUD.Get.IGetter;

import java.util.List;

public interface ICRUDManager {
    boolean addWishlist(Wishlist wishlist);
    boolean addWish(String wishlistId, Wish w);
    Wishlist getWishlistById(String id);
    Wish getWishById(String id);
    List<Wishlist> getAllWishlist();
    boolean removeWishlistById(String id);
    boolean removeWish(String id);
    boolean updateWishlist(Wishlist wishlist);
    boolean updateWish(Wish wish);
}
