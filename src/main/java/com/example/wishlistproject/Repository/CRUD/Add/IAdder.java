package com.example.wishlistproject.Repository.CRUD.Add;

import com.example.wishlistproject.Models.Wish;
import com.example.wishlistproject.Models.Wishlist;

public interface IAdder {
    boolean addWishlist(Wishlist wishlist);
    String addWish(String wishlistId, Wish w);
}
