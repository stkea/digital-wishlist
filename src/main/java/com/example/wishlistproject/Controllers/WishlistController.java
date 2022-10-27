package com.example.wishlistproject.Controllers;

import com.example.wishlistproject.Models.Wishlist.Wishlist;
import com.example.wishlistproject.Repository.Wishlist.IDbManager;
import com.example.wishlistproject.Services.Factories.Wishlist.IWishlistFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WishlistController {

    @GetMapping("/wishlists")
    public String getAll(Model model){
        var wls = dbManager.getAllWishlist();
        model.addAttribute("wishlists",wls);
        return "wishlists";
    }

    @GetMapping("wishlist/wishlist")
    public String get(@RequestParam String id, Model model){
        var w = dbManager.getWishlistById(id);
        model.addAttribute("wishlist",w);
        return "wishlist";
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
            return "redirect:/wishlists";
        return "redirect:err";
    }

    @GetMapping("/wishlist/remove")
    public String removeGet(@RequestParam(value = "id") String id, Model model){
        var wl = dbManager.getWishlistById(id);
        if(wl == null)
            return "err";
        model.addAttribute("wishlist",wl);
        return "removeConfirmation";
    }

    @PostMapping("/wishlist/remove")
    public String removePost(@ModelAttribute("wishlist") Wishlist wl){
        if(dbManager.removeWishlistById(wl.getId()))
            return "redirect:/wishlists";
        return "err";
    }

    @GetMapping("/update")
    public String updateGet(@RequestParam("id") String id, Model model){
        var wl = dbManager.getWishlistById(id);
        model.addAttribute("wishlist");
        return "updateForm";
    }

    @PostMapping("/update")
    public String updatePost(@ModelAttribute("wishlist") Wishlist wl){
        if(dbManager.updateWishlist(wl))
            return "redirect:wishlists";
        return "redirect:err";
    }

    @Autowired
    private IDbManager dbManager;
    @Autowired
    private IWishlistFactory factory;
}
