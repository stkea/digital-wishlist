package com.example.wishlistproject.Repository.CRUD.Add;

import com.example.wishlistproject.Models.Wish;
import com.example.wishlistproject.Models.Wishlist;

public interface IAdder {
    boolean add(Wishlist wishlist);
    boolean add(Wishlist wl, Wish w );
}
