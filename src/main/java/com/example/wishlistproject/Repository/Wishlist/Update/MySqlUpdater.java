package com.example.wishlistproject.Repository.Wishlist.Update;

import com.example.wishlistproject.Models.Wishlist.Wish;
import com.example.wishlistproject.Models.Wishlist.Wishlist;
import com.example.wishlistproject.Repository.Wishlist.Add.IDbPersistence;
import com.example.wishlistproject.Repository.Wishlist.Remove.IDbRemover;
import org.springframework.stereotype.Service;

@Service
public class MySqlUpdater implements IDbUpdater {
    public MySqlUpdater(IDbPersistence adder, IDbRemover remover) {
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
    private final IDbPersistence adder;
    private final IDbRemover remover;
}
