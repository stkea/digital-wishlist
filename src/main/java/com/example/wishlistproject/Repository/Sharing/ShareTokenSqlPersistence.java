package com.example.wishlistproject.Repository.Sharing;

import com.example.wishlistproject.Models.Sharing.ShareToken;
import com.example.wishlistproject.Repository.SqlContext.IDbSqlContext;
import org.springframework.stereotype.Service;

@Service
public class ShareTokenSqlPersistence implements ISharingTokenPersistence{
    public ShareTokenSqlPersistence(IDbSqlContext sqlContext) {
        this.sqlContext = sqlContext;
    }

    @Override
    public boolean persist(ShareToken token) {
        var result = sqlContext.runStatement(statement(token));
        return result;
    }

    private String statement(ShareToken token){
        var tokenId = token.getId();
        var wishlistId = token.getWishlistId();
        var tokenLink = token.getTokenLink();
        var tokenKey = token.getTokenKey();
        var statement = String.format("""
                    INSERT INTO ShareToken(Id,WishlistId, TokenLink,TokenKey)
                    VALUES('%s','%s','%s','%s','%s');
                """,tokenId,wishlistId,tokenLink,tokenKey);
        return statement;
    }

    private final IDbSqlContext sqlContext;
}
