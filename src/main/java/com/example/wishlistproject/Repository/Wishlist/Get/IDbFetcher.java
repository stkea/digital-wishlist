package com.example.wishlistproject.Repository.Wishlist.Get;

import com.example.wishlistproject.Models.Wishlist.Wish;
import com.example.wishlistproject.Models.Wishlist.Wishlist;

import java.util.List;

public interface IDbFetcher {
    Wishlist getWishlistById(String id);
    List<Wishlist> getAllWishlist();
    Wish getWishById(String id);
    List<Wish> getWishesByWishlistID(String id);
}
