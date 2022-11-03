package com.example.wishlistproject.Repository.Sharing;

import com.example.wishlistproject.Models.Sharing.ShareToken;
import com.example.wishlistproject.Repository.SqlContext.IDbSqlContext;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class MySqlShareTokenFetcher implements IDbShareTokenFetcher {
    public MySqlShareTokenFetcher(IDbSqlContext sqlContext) {
        this.sqlContext = sqlContext;
    }

    @Override
    public ShareToken get(String tokenKey) {
        try {
            var result = sqlContext.runQuery(query(tokenKey));
            return fromResultSet(result);
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public ShareToken getFromWishlistId(String wishlistID) {
        try {
            var result = sqlContext.runQuery(queryFromWishlistId(wishlistID));
            return fromResultSet(result);
        } catch (SQLException e) {
            return null;
        }
    }

    private boolean validate(String key){
        return true;
    }

    private String query(String key){
        var query = String.format("""
                    SELECT * FROM ShareToken
                    WHERE TokenKey = '%s'
                    LIMIT 1;
                """,key);
        return query;
    }

    private String queryFromWishlistId(String id){
        var query = String.format("""
                    SELECT * FROM ShareToken
                    WHERE WishlistId = '%s'
                    LIMIT 1;
                """,id);
        return query;
    }

    private ShareToken fromResultSet(ResultSet result) throws SQLException {
        if(!result.next())
            return null;
        var id = result.getString("Id");
        var key = result.getString("TokenKey");
        var wishlistId = result.getString("WishlistId");
        var link = result.getString("TokenLink");
        return new ShareToken(id,wishlistId,link,key);
    }

    private final IDbSqlContext sqlContext;
}
