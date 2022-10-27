package com.example.wishlistproject.Services.Factories.Wish;

import com.example.wishlistproject.Models.Wishlist.Wish;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Service
public class WishFactory implements IWishFactory{
    @Override
    public Wish empty(String wishlistId) {
        var id = UUID.randomUUID().toString();
        var w = new Wish(id);
        w.setWishlistId(wishlistId);
        return w;
    }

    @Override
    public Wish fromResultSet(ResultSet result) {
        try {
            String id = result.getString("Id");
            String url = result.getString("Url");
            String wishlistId = result.getString("WishlistId");
            int reserved = result.getInt("Reserved");
            String reservedTo = result.getString("ReservedTo");
            String productTitle = result.getString("ProductTitle");
            double productPrice = result.getDouble("ProductPrice");

            return new Wish(id, url, wishlistId, reserved, reservedTo, productTitle, productPrice);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
