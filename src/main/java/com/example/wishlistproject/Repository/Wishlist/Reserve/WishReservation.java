package com.example.wishlistproject.Repository.Wishlist.Reserve;

import com.example.wishlistproject.Models.Wishlist.Wish;
import com.example.wishlistproject.Repository.Wishlist.Get.IDbFetcher;
import com.example.wishlistproject.Repository.Wishlist.Update.IDbUpdater;
import org.springframework.stereotype.Service;

@Service
public class WishReservation implements IWishReservation{
    public WishReservation(IDbFetcher getter, IDbUpdater updater) {
        this.getter = getter;
        this.updater = updater;
    }

    @Override
    public boolean reserve(Wish wish) {
        wish.reserve();
        return updater.updateWish(wish);
    }

    @Override
    public boolean unReserve(Wish wish) {
        wish.unReserve();
        return updater.updateWish(wish);
    }

    @Override
    public boolean handleReserve(String wishId) {
        Wish wish = getter.getWishById(wishId);
        if (wish.getReserved() > 0)
            return unReserve(wish);
        return reserve(wish);
    }

    private final IDbFetcher getter;
    private final IDbUpdater updater;
}
