package com.example.wishlistproject.Repository.Wishlist.Reserve;

import com.example.wishlistproject.Repository.Wishlist.Get.IGetter;
import com.example.wishlistproject.Repository.Wishlist.Update.IUpdater;
import org.springframework.stereotype.Service;

@Service
public class WishReservation implements IWishReservation{
    public WishReservation(IGetter getter, IUpdater updater) {
        this.getter = getter;
        this.updater = updater;
    }

    @Override
    public boolean reserve(String id, String name) {
        var w = getter.getWishById(id);
        w.reserve(name);
        return updater.updateWish(w);
    }

    @Override
    public boolean unReserve(String id) {
        return false;
    }

    private final IGetter getter;
    private final IUpdater updater;
}
