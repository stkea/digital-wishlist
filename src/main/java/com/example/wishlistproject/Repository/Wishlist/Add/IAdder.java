package com.example.wishlistproject.Repository.Wishlist.Add;

import com.example.wishlistproject.Models.Wishlist.Wish;
import com.example.wishlistproject.Models.Wishlist.Wishlist;

public interface IAdder {
    boolean insertWishlist(Wishlist wishlist);
    boolean insertWish(String wishlistId, Wish w);
}
