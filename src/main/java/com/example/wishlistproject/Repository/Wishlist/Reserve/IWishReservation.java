package com.example.wishlistproject.Repository.Wishlist.Reserve;

import com.example.wishlistproject.Models.Wishlist.Wish;

public interface IWishReservation {
    boolean reserve(Wish wish);
    boolean unReserve(Wish wish);
    boolean handleReserve(String wishId);
}
