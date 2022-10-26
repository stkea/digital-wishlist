package com.example.wishlistproject.Controllers;

import com.example.wishlistproject.Models.Wishlist;
import com.example.wishlistproject.Repository.CRUD.IDbManager;
import com.example.wishlistproject.Services.Factories.IWishlistFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WishlistController {

    @GetMapping("/wishlists")
    public String get(Model model){
        var wls = dbManager.getAllWishlist();
        model.addAttribute("wishlists",wls);
        return "wishlists";
    }

    @GetMapping("/wishlist/create")
    public String createGet(Model model){
        var wl = factory.empty();
        model.addAttribute("wishlist",wl);
        return "createForm";
    }

    @PostMapping("/wishlist/create")
    public String createPost(@ModelAttribute("wishlist") Wishlist wl){
        var result = dbManager.addWishlist(wl);
        if(result)
            return "/wishlists";
        return "index";
    }

    @GetMapping("/remove/{id}")
    public String removeGet(@PathVariable("id") String id, Model model){
        var wl = dbManager.getWishlistById(id);
        model.addAttribute("wishlist");
        return "removeConfirmation";
    }

    @PostMapping("/removeWishlist")
    public String removePost(@ModelAttribute("wishlist") Wishlist wl){
        var result = dbManager.updateWishlist(wl);
        if(result)
            return "wishlists";
        return "Some error page";
    }

    @GetMapping("/update/{id}")
    public String updateGet(@PathVariable("id") String id, Model model){
        var wl = dbManager.getWishlistById(id);
        model.addAttribute("wishlist");
        return "updateForm";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute("wishlist") Wishlist wl){
        var result = dbManager.updateWishlist(wl);
        if(result)
            return "wishlists";
        return "Some error page";
    }

    @Autowired
    private IDbManager dbManager;
    @Autowired
    private IWishlistFactory factory;
}