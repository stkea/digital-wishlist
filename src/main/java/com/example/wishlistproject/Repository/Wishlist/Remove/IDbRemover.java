package com.example.wishlistproject.Repository.Wishlist.Remove;

public interface IDbRemover {
    boolean removeWishlistById(String id);
    boolean removeWishById(String id);
}
