package com.example.wishlistproject.Repository.Wishlist.Get;

import com.example.wishlistproject.Models.Wishlist.Wish;
import com.example.wishlistproject.Models.Wishlist.Wishlist;
import com.example.wishlistproject.Repository.SqlContext.IDbSqlContext;
import com.example.wishlistproject.Services.Factories.Wish.IWishFactory;
import com.example.wishlistproject.Services.Factories.Wishlist.IWishlistFactory;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MySqlFetcher implements IDbFetcher {
    public MySqlFetcher(IDbSqlContext sqlContext, IWishlistFactory wishlistFactory, IWishFactory wishFactory) {
        this.sqlContext = sqlContext;
        this.wishlistFactory = wishlistFactory;
        this.wishFactory = wishFactory;
    }
    @Override
    public Wishlist getWishlistById(String id) {
        Wishlist wishlist;
        try {
            var data = sqlContext.runQuery(String.format("""
                SELECT * FROM Wishlist w WHERE w.Id = '%s';
                """, id));
            if(!data.next())
                return null;
            wishlist = wishlistFactory.fromResultSet(data);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        // Retrieve wishes for the wishlist and append them to the wishlist
        List<Wish> wishes = getWishesByWishlistID(id);
        wishlist.setWishes(wishes);
        return wishlist;
    }

    @Override
    public List<Wishlist> getAllWishlist() {
        List<Wishlist> wishlists = new ArrayList<>();
        try {
            ResultSet data = sqlContext.runQuery("""
                SELECT * FROM Wishlist;
                """);
            while (data.next()) {
                Wishlist wishlist = wishlistFactory.fromResultSet(data);
                // Retrieve wishes for the current wishlist and append them to the wishlist
                List<Wish> wishes = getWishesByWishlistID(wishlist.getId());
                wishlist.setWishes(wishes);
                wishlists.add(wishlist);
            }
        } catch (SQLException e) {
            System.out.println("Failed trying to retrieve all wishlists");
            return new ArrayList<>();
        }
        return wishlists;
    }

    @Override
    public Wish getWishById(String id) {
        try {
            ResultSet data = sqlContext.runQuery(String.format("""
                SELECT * FROM Wish w
                WHERE w.Id = '%s';
                """, id));
            if(!data.next())
                return null;
            return wishFactory.fromResultSet(data);
        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Wish> getWishesByWishlistID(String id) {
        List<Wish> wishes = new ArrayList<>();
        try {
            ResultSet data = sqlContext.runQuery(String.format("""
                SELECT * FROM Wish
                WHERE WishlistId = '%s';
                """, id));
            while (data.next()) {
                Wish wish = wishFactory.fromResultSet(data);
                wishes.add(wish);
            }
        } catch (SQLException e) {
            System.out.println("Failed trying to retrieve wishes for wishlistId: " + id);
            System.out.println(e);
        }
        return wishes;
    }

    private final IDbSqlContext sqlContext;
    private final IWishlistFactory wishlistFactory;
    private final IWishFactory wishFactory;
}
