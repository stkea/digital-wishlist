package com.example.wishlistproject.Repository.CRUD;

import com.example.wishlistproject.Models.Wish;
import com.example.wishlistproject.Models.Wishlist;
import com.example.wishlistproject.Repository.CRUD.Add.IAdder;
import com.example.wishlistproject.Repository.CRUD.Get.IGetter;
import com.example.wishlistproject.Repository.CRUD.Remove.IRemover;
import com.example.wishlistproject.Repository.CRUD.Update.IUpdater;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRUDManager implements ICRUDManager{
    public CRUDManager(IAdder adder, IGetter getter, IRemover remover, IUpdater updater) {
        this.adder = adder;
        this.getter = getter;
        this.remover = remover;
        this.updater = updater;
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
        return false;
    }

    @Override
    public boolean removeWish(String id) {
        return false;
    }

    @Override
    public boolean updateWishlist(Wishlist wishlist) {
        return false;
    }

    @Override
    public boolean updateWish(Wish wish) {
        return false;
    }

    private final IAdder adder;
    private final IGetter getter;
    private final IRemover remover;
    private final IUpdater updater;
}
