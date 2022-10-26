package com.example.wishlistproject.Repository.Query;

import java.sql.ResultSet;

public interface IDbSqlContext {
    ResultSet runQuery(String sql);

    boolean runStatement(String sql);
}
