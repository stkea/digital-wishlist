package com.example.wishlistproject.Repository.CRUD;

import com.example.wishlistproject.Models.Wish;
import com.example.wishlistproject.Models.Wishlist;
import com.example.wishlistproject.Repository.CRUD.Add.IAdder;
import com.example.wishlistproject.Repository.CRUD.Get.IGetter;

import java.util.List;

public interface ICRUDManager {
    boolean addWishlist(Wishlist wishlist);
    Wishlist getWishlistById(String id);
    boolean removeWishlistById(String id);
    boolean updateWishlist(Wishlist wishlist);
    boolean addWish(String wishlistId, Wish w);
    Wish getWishById(String id);
    List<Wishlist> getAllWishlist();
    boolean removeWish(String id);
    boolean updateWish(Wish wish);
}
