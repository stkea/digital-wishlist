package com.example.wishlistproject.Repository.Sharing;

import com.example.wishlistproject.Models.Sharing.ShareToken;
import com.example.wishlistproject.Repository.SqlContext.IDbSqlContext;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class DbShareTokenFetcher implements IDbShareTokenFetcher {
    public DbShareTokenFetcher(IDbSqlContext sqlContext) {
        this.sqlContext = sqlContext;
    }

    @Override
    public ShareToken get(String tokenKey) {
        var result = sqlContext.runQuery(query(tokenKey));
        ShareToken token;
        try {
            token = fromResultSet(result);
        } catch (SQLException e) {
            return null;
        }
        return token;
    }

    private boolean validate(String key){
        return true;
    }

    private String query(String key){
        var query = String.format("""
                    SELECT * FROM ShareToken
                    WHERE TokenKey = %s
                    LIMIT 1;
                """,key);
        return query;
    }

    private ShareToken fromResultSet(ResultSet result) throws SQLException {
        if(!result.next())
            return null;
        var id = result.getString("Id");
        var key = result.getString("TokenKey");
        var wishlistId = result.getString("wishlistId");
        var link = result.getString("TokenLink");
        return new ShareToken(id,wishlistId,link,key);
    }

    private final IDbSqlContext sqlContext;
}
