package com.example.wishlistproject.Services.Factories.Wishlist;

import com.example.wishlistproject.Models.Wishlist.Wishlist;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Service
public class WishlistFactory implements IWishlistFactory{
    @Override
    public Wishlist empty() {
        var id = UUID.randomUUID().toString();
        var wls = new Wishlist(id);
        return wls;
    }

    @Override
    public Wishlist fromResultSet(ResultSet result) {
        try {
            String id = result.getString("Id");
            String Title = result.getString("Title");
            String Creator = result.getString("Creator");
            String exp = result.getString("Expiration");
            return new Wishlist(id, Title, Creator, exp);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
