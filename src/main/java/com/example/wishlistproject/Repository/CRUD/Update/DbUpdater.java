package com.example.wishlistproject.Repository.CRUD.Update;

import com.example.wishlistproject.Models.Wish;
import com.example.wishlistproject.Models.Wishlist;
import com.example.wishlistproject.Repository.Query.IDbSqlContext;
import com.example.wishlistproject.Services.Converters.IWishlistConverter;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class DbUpdater implements IUpdater{
    public DbUpdater(IDbSqlContext sqlContext, IWishlistConverter converter) {
        this.sqlContext = sqlContext;
        this.converter = converter;
    }

    @Override
    public boolean updateWishlist(Wishlist wishlist) {
        if(!removeWishlist(wishlist.getId()))
            return false;
        if(!addWishlist(wishlist))
            return false;
        return true;
    }

    @Override
    public boolean updateWish(Wish wish) {
        return false;
    }

    private boolean removeWishlist(String id){
        var result = sqlContext
                .runStatement(String.format("""
                        REMOVE FROM Wishlist w
                        WHERE w.Id = %s; 
                        """,id));
        return result;
    }

    private boolean removeWish(String id){
        var result = sqlContext
                .runStatement(String.format("""
                        REMOVE FROM Wish w
                        WHERE w.Id = %s; 
                        """,id));
        return result;
    }

    private boolean addWishlist(Wishlist w){
        var sql = converter.convert(w);
        return sqlContext.runStatement(sql);
    }

    private final IDbSqlContext sqlContext;
    private final IWishlistConverter converter;
}
