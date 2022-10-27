package com.example.wishlistproject.Repository.Wishlist.Reserve;

public interface IWishReservation {
    boolean reserve(String id, String name);
    boolean unReserve(String id);
}
