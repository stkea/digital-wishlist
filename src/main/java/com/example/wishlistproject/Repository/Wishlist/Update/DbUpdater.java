package com.example.wishlistproject.Repository.Wishlist.Update;

import com.example.wishlistproject.Models.Wishlist.Wish;
import com.example.wishlistproject.Models.Wishlist.Wishlist;
import com.example.wishlistproject.Repository.Wishlist.Add.IAdder;
import com.example.wishlistproject.Repository.Wishlist.Remove.IRemover;
import org.springframework.stereotype.Service;

@Service
public class DbUpdater implements IUpdater{
    public DbUpdater(IAdder adder, IRemover remover) {
        this.adder = adder;
        this.remover = remover;
    }

    @Override
    public boolean updateWishlist(Wishlist wishlist) {
        return remover.removeWishlistById(wishlist.getId())
                && adder.insertWishlist(wishlist);
    }

    @Override
    public boolean updateWish(Wish wish) {
        return remover.removeWishById(wish.getId())
                && adder.insertWish(wish.getWishlistId(),wish);
    }
    private final IAdder adder;
    private final IRemover remover;
}
