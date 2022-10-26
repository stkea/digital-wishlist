package com.example.wishlistproject.Controllers;

import com.example.wishlistproject.Repository.CRUD.IDbManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    public HomeController(IDbManager manager) {
        this.manager = manager;
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    private final IDbManager manager;
}
