package com.example.wishlistproject.Services.Converters;

import com.example.wishlistproject.Models.Wish;
import com.example.wishlistproject.Models.Wishlist;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class Converter implements IConverter {
    @Override
    public String convertWishlist(Wishlist wishlist) {
        return null;
    }

    @Override
    public Wishlist convertWishlist(ResultSet result) {
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

    @Override
    public String convertWish(Wish wish) {
        return null;
    }

    @Override
    public Wish convertWish(ResultSet result) {
        try {
            String id = result.getString("Id");
            String url = result.getString("Url");
            String wishlistId = result.getString("WishlistId");
            int reserved = result.getInt("Reserved");
            String reservedTo = result.getString("ReservedTo");
            String productTitle = result.getString("ProductTitle");

            // TODO: Change from int to double in database script
            double productPrice = result.getDouble("ProductPrice");

            return new Wish(id, url, wishlistId, reserved, reservedTo, productTitle, productPrice);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
