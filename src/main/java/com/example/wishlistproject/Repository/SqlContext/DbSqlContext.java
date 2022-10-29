package com.example.wishlistproject.Repository.SqlContext;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class DbSqlContext implements IDbSqlContext {
    @Override
    public ResultSet runQuery(String sql) throws SQLException {
        var dbConnector = DbConnection.getInstance(url,username,password);
        var con = dbConnector.get();
        if(con == null)
            throw  new SQLException();
        return con.prepareStatement(sql).executeQuery();
    }

    @Override
    public boolean runStatement(String sql){
        var dbConnector = DbConnection.getInstance(url,username,password);
        var con = dbConnector.get();
        if(con == null)
            return false;
        try {
            con.createStatement().execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;
}
