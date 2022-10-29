package com.example.wishlistproject.Services.Factories.Wishlist;

import com.example.wishlistproject.Models.Wishlist.Wishlist;

import java.sql.ResultSet;

public interface IWishlistFactory {
    Wishlist empty();
    Wishlist fromResultSet(ResultSet result);
}
