package com.example.wishlistproject.Controllers;

import com.example.wishlistproject.Persitence.Query.MySqlQueryContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/*
    For testing purposes only
 */

@RestController
public class HomeController {

    @GetMapping("/")
    public String home(){
        var r = queryContext.runQuery("SELECT * FROM Wishlist;");
        try {
            if(r.next())
                return "Result is not empty";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Result is empty";
    }

    @Autowired
    private MySqlQueryContext queryContext;
}
