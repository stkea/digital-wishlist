package com.example.wishlistproject.Repository.CRUD;

import com.example.wishlistproject.Models.Wish;
import com.example.wishlistproject.Models.Wishlist;
import com.example.wishlistproject.Repository.CRUD.Add.IAdder;
import com.example.wishlistproject.Repository.CRUD.Get.IGetter;
import com.example.wishlistproject.Repository.CRUD.Remove.IRemover;
import com.example.wishlistproject.Repository.CRUD.Update.IUpdater;

import java.util.List;

public class CRUDManager implements ICRUDManager{
    public CRUDManager(IAdder adder, IGetter getter, IRemover remover, IUpdater updater) {
        this.adder = adder;
        this.getter = getter;
        this.remover = remover;
        this.updater = updater;
    }

    @Override
    public boolean addWishlist(Wishlist wishlist) {
        return false;
    }

    @Override
    public boolean addWish(String wishlistId, Wish w) {
        return false;
    }

    @Override
    public Wishlist getWishlistById(String id) {
        return null;
    }

    @Override
    public Wish getWishById(String id) {
        return null;
    }

    @Override
    public List<Wishlist> getAllWishlist() {
        return null;
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

    private IAdder adder;
    private IGetter getter;
    private IRemover remover;
    private IUpdater updater;
}
