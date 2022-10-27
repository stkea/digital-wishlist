package com.example.wishlistproject.Repository.CRUD.Remove;

import com.example.wishlistproject.Repository.DbContext.IDbSqlContext;
import org.springframework.stereotype.Service;

@Service
public class DbRemover implements IRemover {
    public DbRemover(IDbSqlContext sqlContext) {
        this.sqlContext = sqlContext;
    }

    @Override
    public boolean removeWishlistById(String id) {
        return removeAssociatedWishes(id) &&
                removeWishList(id);
    }

    private boolean removeAssociatedWishes(String id){
        var result = sqlContext.runStatement(String.format("""
                DELETE FROM Wish
                WHERE WishlistId='%s';
                """,id));
        return result;
    }

    private boolean removeWishList(String id){
        var result = sqlContext
                .runStatement(String.format("""
                        DELETE FROM Wishlist
                        WHERE Id='%s';
                        """,id));
        return result;
    }

    @Override
    public boolean removeWishById(String id) {
        var result = sqlContext
                .runStatement(String.format("""
                        DELETE FROM Wish
                        WHERE Id = '%s';
                        """,id));
        return result;
    }

    private final IDbSqlContext sqlContext;
}
