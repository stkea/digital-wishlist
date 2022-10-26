package com.example.wishlistproject.Repository.CRUD.Add;

import com.example.wishlistproject.Models.Wish;
import com.example.wishlistproject.Models.Wishlist;

public interface IAdder {
    boolean addWishlist(Wishlist wishlist);
    boolean addWish(String wishlistId, Wish w);
}
