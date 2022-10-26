package com.example.wishlistproject.Repository.Query;

import com.example.wishlistproject.Repository.Connection.DbConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class DbSqlContext implements IDbSqlContext {
    @Override
    public ResultSet runQuery(String sql){
        var dbConnector = DbConnection.getInstance(url,username,password);
        var con = dbConnector.get();
        try {
            return con.prepareStatement(sql).executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean runStatement(String sql){
        var dbConnector = DbConnection.getInstance(url,username,password);
        var con = dbConnector.get();
        try {
            return con.prepareStatement(sql).execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;
}
