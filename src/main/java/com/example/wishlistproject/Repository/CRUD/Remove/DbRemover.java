package com.example.wishlistproject.Repository.CRUD.Remove;

import com.example.wishlistproject.Repository.Query.IDbSqlContext;
import org.springframework.stereotype.Service;

@Service
public class DbRemover implements IRemover {
    public DbRemover(IDbSqlContext sqlContext) {
        this.sqlContext = sqlContext;
    }

    @Override
    public boolean removeWishlistById(String id) {
        var result = sqlContext
                .runStatement(String.format("""
                        REMOVE FROM Wish
                        WHERE wishlistId='%s';
                        REMOVE FROM Wishlist
                        WHERE Id = '%s';
                        """,id,id));
        return result;
    }

    @Override
    public boolean removeWishById(String id) {
        var result = sqlContext
                .runStatement(String.format("""
                        REMOVE FROM Wish
                        WHERE Id = '%s';
                        """,id));
        return result;
    }

    private final IDbSqlContext sqlContext;
}
