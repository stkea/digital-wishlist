package com.example.wishlistproject.Repository.CRUD.Add;

import com.example.wishlistproject.Models.Wish;
import com.example.wishlistproject.Models.Wishlist;
import com.example.wishlistproject.Repository.Query.IDbSqlContext;
import org.springframework.stereotype.Service;

@Service
public class DBAdder implements IAdder{
    @Override
    public boolean addWishlist(Wishlist wishlist) {
        boolean result = sqlContext.runStatement(String.format("""
                INSERT INTO Wishlist (Id,Name,Creator,Expiration)
                VALUES(%s, %s, %s, %s); 
                """, wishlist.getId(), wishlist.getTitle(), wishlist.getCreatorName(), wishlist.getExpiration()));
        return result;
    }

    @Override
    public String addWish(String wishlistId, Wish w) {
        /*
        String result = sqlContext.runStatement(String.format("""
                INSERT INTO Wish(Id,Url,WishlistId)
                VALUES(%s, %s, %s);
                """, w.getId()))

         */
        return "";
    }

    private IDbSqlContext sqlContext;
}
