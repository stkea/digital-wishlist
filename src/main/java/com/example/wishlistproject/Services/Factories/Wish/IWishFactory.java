package com.example.wishlistproject.Services.Factories.Wish;

import com.example.wishlistproject.Models.Wishlist.Wish;

import java.sql.ResultSet;

public interface IWishFactory {
    Wish empty(String wishlist);
    Wish fromResultSet(ResultSet result);
}
