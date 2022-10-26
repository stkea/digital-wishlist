package com.example.wishlistproject.Repository.CRUD.Add;

import com.example.wishlistproject.Models.Wish;
import com.example.wishlistproject.Models.Wishlist;

public interface IAddToWishlist {
    boolean add(String wishlistId, Wish w);
}
