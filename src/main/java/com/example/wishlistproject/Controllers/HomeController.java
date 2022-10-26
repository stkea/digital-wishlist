package com.example.wishlistproject.Controllers;

import com.example.wishlistproject.Models.Wish;
import com.example.wishlistproject.Repository.CRUD.Get.IGetter;
import com.example.wishlistproject.Repository.CRUD.ICRUDManager;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
    For testing purposes only
 */

@RestController
public class HomeController {

    public HomeController(ICRUDManager manager) {
        this.manager = manager;
    }

    @GetMapping("/")
    public String home(Model model){
        var list = manager.getAllWishlist();
        model.addAttribute("wishlists",list);
        return "index";
    }

    private final ICRUDManager manager;
}
