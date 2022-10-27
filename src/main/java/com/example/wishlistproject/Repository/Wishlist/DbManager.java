package com.example.wishlistproject.Repository.Wishlist;

import com.example.wishlistproject.Models.Wishlist.Wish;
import com.example.wishlistproject.Models.Wishlist.Wishlist;
import com.example.wishlistproject.Repository.Wishlist.Add.IAdder;
import com.example.wishlistproject.Repository.Wishlist.Get.IGetter;
import com.example.wishlistproject.Repository.Wishlist.Remove.IRemover;
import com.example.wishlistproject.Repository.Wishlist.Reserve.IWishReservation;
import com.example.wishlistproject.Repository.Wishlist.Update.IUpdater;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DbManager implements IDbManager {
    public DbManager(IAdder adder, IGetter getter, IRemover remover, IUpdater updater, IWishReservation reservation) {
        this.adder = adder;
        this.getter = getter;
        this.remover = remover;
        this.updater = updater;
        this.reservation = reservation;
    }

    @Override
    public boolean addWishlist(Wishlist wishlist) {
        return adder.insertWishlist(wishlist);
    }

    @Override
    public boolean addWish(String wishlistId, Wish w) {
        return adder.insertWish(wishlistId, w);
    }

    @Override
    public Wishlist getWishlistById(String id) {
        return getter.getWishlistById(id);
    }

    @Override
    public Wish getWishById(String id) {
        return getter.getWishById(id);
    }

    @Override
    public List<Wishlist> getAllWishlist() {
        return getter.getAllWishlist();
    }

    @Override
    public boolean removeWishlistById(String id) {
        return remover.removeWishlistById(id);
    }

    @Override
    public boolean removeWish(String id) {
        return remover.removeWishById(id);
    }

    @Override
    public boolean updateWishlist(Wishlist wishlist) {
        return updater.updateWishlist(wishlist);
    }

    @Override
    public List<Wish> getAllWishes(String wishlistId) {
        return getter.getWishesByWishlistID(wishlistId);
    }

    @Override
    public boolean updateWish(Wish wish) {
        return updater.updateWish(wish);
    }

    @Override
    public boolean reserveWish(String wishId, String name) {
        return false;
    }

    private final IAdder adder;
    private final IGetter getter;
    private final IRemover remover;
    private final IUpdater updater;
    private final IWishReservation reservation;
}
