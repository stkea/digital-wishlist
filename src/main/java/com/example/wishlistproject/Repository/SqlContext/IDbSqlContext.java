package com.example.wishlistproject.Repository.SqlContext;

import java.sql.ResultSet;

public interface IDbSqlContext {
    ResultSet runQuery(String sql);

    boolean runStatement(String sql);
}
