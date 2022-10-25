package com.example.wishlistproject.Persitence.Query;

import com.example.wishlistproject.Persitence.Connection.DbConnection;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;


@Service
public class MySqlQueryContext {
    public ResultSet runQuery(String query){
        var dbConnector = DbConnection.getInstance(url,username,password);
        var con = dbConnector.get();
        try {
            return con.createStatement().executeQuery(query);
        } catch (SQLException e) {
            return null;
        }
    }

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;
}
