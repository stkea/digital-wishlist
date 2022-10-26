package com.example.wishlistproject.Repository.CRUD.Add;

import com.example.wishlistproject.Models.Wish;
import com.example.wishlistproject.Models.Wishlist;

public interface IAdder {
    boolean insertWishlist(Wishlist wishlist);
    boolean insertWish(String wishlistId, Wish w);
}
