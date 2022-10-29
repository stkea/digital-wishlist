package com.example.wishlistproject.Repository.SqlContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDbSqlContext {
    ResultSet runQuery(String sql) throws SQLException;

    boolean runStatement(String sql);
}
