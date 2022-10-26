package com.example.wishlistproject.Services.Converters;

import com.example.wishlistproject.Models.Wishlist;

import java.sql.ResultSet;

public interface IWishlistConverter {
    String convert(Wishlist wishlist);
    Wishlist convert(ResultSet result);
}
