package com.example.wishlistproject.Services.Converters;

import com.example.wishlistproject.Models.Wish;
import com.example.wishlistproject.Models.Wishlist;

import java.sql.ResultSet;

public interface IConverter {
    String convertWishlist(Wishlist wishlist);
    Wishlist convertWishlist(ResultSet result);

    String convertWish(Wish wish);
    Wish convertWish(ResultSet result);
}
