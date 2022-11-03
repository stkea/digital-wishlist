package com.example.wishlistproject.Repository.Sharing;

import com.example.wishlistproject.Models.Sharing.ShareToken;
import com.example.wishlistproject.Repository.SqlContext.IDbSqlContext;
import org.springframework.stereotype.Service;

@Service
public class ShareTokenSqlPersistence implements ISharingTokenPersistence{
    public ShareTokenSqlPersistence(IDbSqlContext sqlContext, IDbShareTokenFetcher fetcher) {
        this.sqlContext = sqlContext;
        this.fetcher = fetcher;
    }

    @Override
    public boolean persist(ShareToken shareToken) {
        var token = fetcher.get(shareToken.getTokenKey());
        if(token != null)
            return false;
        var statement = statement(shareToken);
        var result = sqlContext.runStatement(statement);
        return result;
    }

    private String statement(ShareToken token){
        var tokenId = token.getId();
        var wishlistId = token.getWishlistId();
        var tokenLink = token.getTokenLink();
        var tokenKey = token.getTokenKey();
        var statement = String.format("""
                    INSERT INTO ShareToken(Id,WishlistId, TokenLink,TokenKey)
                    VALUES('%s','%s','%s','%s');
                """,tokenId,wishlistId,tokenLink,tokenKey);
        return statement;
    }

    private final IDbSqlContext sqlContext;
    private final IDbShareTokenFetcher fetcher;
}
