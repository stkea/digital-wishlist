package com.example.wishlistproject.Services.Factories;

import com.example.wishlistproject.Models.Wishlist;

import java.sql.ResultSet;

public interface IWishlistFactory {
    Wishlist empty();
    Wishlist fromResultSet(ResultSet result);
}
