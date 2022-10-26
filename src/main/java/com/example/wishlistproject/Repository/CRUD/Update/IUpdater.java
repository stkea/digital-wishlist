package com.example.wishlistproject.Repository.CRUD.Update;

import com.example.wishlistproject.Models.Wish;
import com.example.wishlistproject.Models.Wishlist;

public interface IUpdater {
    boolean updateWishlist(Wishlist wishlist);
    boolean updateWish(Wish wish);
}
