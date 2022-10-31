package com.example.wishlistproject.Controllers;

import com.example.wishlistproject.Models.Wishlist.Wish;
import com.example.wishlistproject.Models.Wishlist.Wishlist;
import com.example.wishlistproject.Repository.Wishlist.IDbManager;
import com.example.wishlistproject.Services.Factories.Wish.IWishFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class WishController {
    @GetMapping("wishlist/wishes")
    public String get(@RequestParam(value = "wishlistId") String wishlistId, Model model){
        session.setAttribute("wishlistId",wishlistId);
        var w = dbManager.getAllWishes(wishlistId);
        Wishlist wl = dbManager.getWishlistById(wishlistId);
        model.addAttribute("wishlist", wl);
        model.addAttribute("wishes",w);
        return "wishes";
    }

    @GetMapping("wish/create")
    public String create(Model model){
        var id = session.getAttribute("wishlistId").toString();
        var w = factory.empty(id);
        model.addAttribute("wish",w);
        return "createWishForm";
    }

    @PostMapping("wish/create")
    public String createPost(@ModelAttribute("wish") Wish wish){
        var id = session.getAttribute("wishlistId").toString();
        if(dbManager.addWish(id,wish))
            return "redirect:/wishlist/wishes?wishlistId=" + id;
        return "redirect:err";
    }


    @PostMapping("wish/removeWish")
    public String removeGet(@ModelAttribute("wish") Wish wish){
        String wishlistId = session.getAttribute("wishlistId").toString();
        if(dbManager.removeWish(wish.getId()))
            return "redirect:/wishlist/wishes?wishlistId=" + wishlistId;
        return "redirect:err";
    }

    @GetMapping("wish/update")
    public String updateGet(@RequestParam(value = "id") String id, Model model){
        var w = dbManager.getWishById(id);
        model.addAttribute("wish",w);
        return "updateWishForm";
    }

    @PostMapping("wish/update")
    public String updateGet(@ModelAttribute("wish") Wish wish){
        if(dbManager.updateWish(wish))
            return "redirect:/wishlist/wishes?wishlistId=" + wish.getWishlistId();
        return "redirect:err";
    }

    @PostMapping("wish/reserve")
    public String reserve(@RequestParam(value = "wishId") String wishId) {
       if(dbManager.handleReserve(wishId)) {
           String id = session.getAttribute("wishlistId").toString();
           return "redirect:/wishlist/wishes?wishlistId=" + id;
       }
        return "redirect:err";
    }

    @Autowired
    private IDbManager dbManager;
    @Autowired
    private IWishFactory factory;

    @Autowired
    private HttpSession session;
}
