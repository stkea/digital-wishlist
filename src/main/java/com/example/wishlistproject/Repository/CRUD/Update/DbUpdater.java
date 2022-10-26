package com.example.wishlistproject.Repository.CRUD.Update;

import com.example.wishlistproject.Models.Wish;
import com.example.wishlistproject.Models.Wishlist;
import com.example.wishlistproject.Repository.CRUD.Add.IAdder;
import com.example.wishlistproject.Repository.CRUD.Remove.IRemover;
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
                && adder.addWishlist(wishlist);
    }

    @Override
    public boolean updateWish(Wish wish) {
        return remover.removeWishById(wish.getId())
                && adder.addWish(wish.getWishlistId(),wish);
    }

    private final IAdder adder;
    private final IRemover remover;
}
