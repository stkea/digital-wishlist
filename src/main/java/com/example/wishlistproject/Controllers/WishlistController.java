package com.example.wishlistproject.Controllers;

import com.example.wishlistproject.Models.Wishlist.Wishlist;
import com.example.wishlistproject.Repository.Wishlist.IDbManager;
import com.example.wishlistproject.Services.Factories.Wishlist.IWishlistFactory;
import com.example.wishlistproject.Services.Security.SqlProtection.UUIDValidator.IStringValidator;
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
        return "/Wishlist/wishlists";
    }

    @GetMapping("/wishlist/create")
    public String createGet(Model model){
        var wl = factory.empty();
        model.addAttribute("wishlist",wl);
        return "/Wishlist/createForm";
    }

    @PostMapping("/wishlist/create")
    public String createPost(@ModelAttribute("wishlist") Wishlist wl){
        var result = dbManager.addWishlist(wl);
        if(result)
            return String.format("redirect:/wishlist?wishlistId=%s", wl.getId());
        return "redirect:err";
    }


    @PostMapping("/wishlist/remove")
    public String removePost(@RequestParam String id){
        if(idValidator.validate(id) && dbManager.removeWishlistById(id))
            return "redirect:/wishlists";
        return "err";
    }

    @GetMapping("/update")
    public String updateGet(@RequestParam String id, Model model){
        if(!idValidator.validate(id))
            return "redirect:bad_input";
        var wl = dbManager.getWishlistById(id);
        model.addAttribute("wishlist");
        return "/Wishlist/updateForm";
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

    @Autowired
    private IStringValidator idValidator;
}
