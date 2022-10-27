package com.example.wishlistproject.Repository.CRUD.Reserve;

import com.example.wishlistproject.Models.Wish;

public interface IWishReservation {
    boolean reserve(String id, String name);
    boolean unReserve(String id);
}
