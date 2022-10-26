package com.example.wishlistproject.Services.Factories;

import com.example.wishlistproject.Models.Wish;

import java.sql.ResultSet;

public interface IWishFactory {
    Wish empty(String wishlist);
    Wish fromResultSet(ResultSet result);
}
