package com.example.wishlistproject.Repository.Wishlist.Update;

import com.example.wishlistproject.Models.Wishlist.Wish;
import com.example.wishlistproject.Models.Wishlist.Wishlist;

public interface IDbUpdater {
    boolean updateWishlist(Wishlist wishlist);
    boolean updateWish(Wish wish);
}
