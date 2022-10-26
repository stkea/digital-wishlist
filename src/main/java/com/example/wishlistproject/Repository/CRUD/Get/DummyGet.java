package com.example.wishlistproject.Repository.CRUD.Get;

import com.example.wishlistproject.Models.Wish;
import com.example.wishlistproject.Models.Wishlist;
import org.springframework.stereotype.Service;
import java.util.List;

/*
    Dummy service

    Delete this when implementing IGetter
 */

@Service
public class DummyGet implements IGetter{
    @Override
    public Wishlist getWishlistById(String id) {
        return null;
    }

    @Override
    public List<Wishlist> getAllWishlist() {
        return null;
    }

    @Override
    public Wish getWishById(String id) {
        return null;
    }

    @Override
    public List<Wish> getAllWishes() {
        return null;
    }
}
