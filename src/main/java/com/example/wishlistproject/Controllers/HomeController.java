package com.example.wishlistproject.Controllers;

import com.example.wishlistproject.Repository.Wishlist.IDbManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @GetMapping()
    public String home(){
        return "index";
    }

    @GetMapping("about")
    public String about(){
        return "about";
    }
}
