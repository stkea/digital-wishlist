package com.example.wishlistproject.Repository.CRUD.Get;

import com.example.wishlistproject.Models.Wish;
import com.example.wishlistproject.Models.Wishlist;
import com.example.wishlistproject.Repository.Query.IDbSqlContext;
import com.example.wishlistproject.Services.Converters.IConverter;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
    Dummy service

    Delete this when implementing IGetter
 */

@Service
public class DBGetter implements IGetter{
    public DBGetter(IDbSqlContext sqlContext, IConverter converter) {
        this.sqlContext = sqlContext;
        this.converter = converter;
    }
    @Override
    public Wishlist getWishlistById(String id) {
        ResultSet data = sqlContext.runQuery(String.format("""
                SELECT * FROM Wishlist w WHERE w.Id = '%s';
                """, id));
        Wishlist wishlist = converter.convertWishlist(data);
        // Retrieve wishes for the wishlist and append them to the wishlist
        List<Wish> wishes = getWishesByWishlistID(id);
        wishlist.setWishes(wishes);
        return wishlist;
    }

    @Override
    public List<Wishlist> getAllWishlist() {
        List<Wishlist> wishlists = new ArrayList<>();
        ResultSet data = sqlContext.runQuery("""
                SELECT * FROM Wishlist;
                """);
        try {
            while (data.next()) {
                Wishlist wishlist = converter.convertWishlist(data);
                // Retrieve wishes for the current wishlist and append them to the wishlist
                List<Wish> wishes = getWishesByWishlistID(wishlist.getId());
                wishlist.setWishes(wishes);
                wishlists.add(wishlist);
            }
        } catch (SQLException e) {
            System.out.println("Failed trying to retrieve all wishlists");
        }
        return wishlists;
    }

    @Override
    public Wish getWishById(String id) {
        ResultSet data = sqlContext.runQuery(String.format("""
                SELECT * FROM Wish w
                WHERE w.Id = '%s';
                """, id));
        Wish wish = converter.convertWish(data);
        return wish;
    }

    @Override
    public List<Wish> getWishesByWishlistID(String id) {
        List<Wish> wishes = new ArrayList<>();
        ResultSet data = sqlContext.runQuery(String.format("""
                SELECT * FROM Wish
                WHERE WishlistId = '%s';
                """, id));
        try {
            while (data.next()) {
                Wish wish = converter.convertWish(data);
                wishes.add(wish);
            }
        } catch (SQLException e) {
            System.out.println("Failed trying to retrieve wishes for wishlistId: " + id);
            System.out.println(e);
        }
        return wishes;
    }

    private IDbSqlContext sqlContext;
    private IConverter converter;
}
