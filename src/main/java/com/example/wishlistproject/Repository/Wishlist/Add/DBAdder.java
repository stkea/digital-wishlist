package com.example.wishlistproject.Repository.Wishlist.Add;

import com.example.wishlistproject.Models.Wishlist.Wish;
import com.example.wishlistproject.Models.Wishlist.Wishlist;
import com.example.wishlistproject.Repository.SqlContext.IDbSqlContext;
import org.springframework.stereotype.Service;

@Service
public class DBAdder implements IAdder{

    public DBAdder(IDbSqlContext sqlContext) {
        this.sqlContext = sqlContext;
    }

    @Override
    public boolean insertWishlist(Wishlist wishlist) {
        boolean result = runInsertWishlistQuery(wishlist);
        if (wishlist.getWishes().size() > 0) {
            String wishlistId = wishlist.getId();
            wishlist.getWishes().stream().forEach(wish -> {
                insertWish(wishlistId, wish);
            });
        }
        return result;
    }

    @Override
    public boolean insertWish(String wishlistId, Wish w) {
        boolean result = runInsertWishQuery(w, wishlistId);
        return result;
    }

    private Boolean runInsertWishQuery(Wish w, String wishlistId) {
        return sqlContext.runStatement(String.format("""
                INSERT INTO Wish(Id,Url,ProductTitle,ProductPrice,WishlistId)
                VALUES('%s', '%s', '%s', %f, '%s');
                """, w.getId(), w.getProductImageURL(), w.getProductTitle(), w.getProductPrice(), wishlistId));
    }
    private Boolean runInsertWishlistQuery(Wishlist wishlist) {
        return sqlContext.runStatement(String.format("""
                INSERT INTO Wishlist (Id,Title,Creator,Expiration)
                VALUES('%s', '%s', '%s', '%s'); 
                """, wishlist.getId(), wishlist.getTitle(), wishlist.getCreatorName(), wishlist.getExpiration()));
    }

    private IDbSqlContext sqlContext;
}