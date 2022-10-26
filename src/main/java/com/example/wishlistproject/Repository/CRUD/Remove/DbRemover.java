package com.example.wishlistproject.Repository.CRUD.Remove;

import com.example.wishlistproject.Models.Wishlist;
import com.example.wishlistproject.Repository.Query.IDbSqlContext;
import org.springframework.stereotype.Service;

@Service
public class DbRemover implements IRemover {
    public DbRemover(IDbSqlContext sqlContext) {
        this.sqlContext = sqlContext;
    }

    @Override
    public boolean removeWishlistById(String id) {
        return removeWishlist(id);
    }

    @Override
    public boolean removeWishById(String id) {
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

    private final IDbSqlContext sqlContext;
}
