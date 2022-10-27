package com.example.wishlistproject.Controllers;

import com.example.wishlistproject.Models.Wishlist.Wish;
import com.example.wishlistproject.Repository.Wishlist.IDbManager;
import com.example.wishlistproject.Services.Factories.Wish.IWishFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;

@Controller
public class WishController {
    @GetMapping("wish/wishes")
    public String get(@RequestParam String wishlistId, Model model){
        session.setAttribute("wishlistId",wishlistId);
        var w = dbManager.getAllWishes(wishlistId);
        model.addAttribute("wishlistId",wishlistId);
        model.addAttribute("wishes",w);
        return "wishes";
    }

    @GetMapping("wish/create")
    public String create(Model model){
        var id = session.getAttribute("wishlistId").toString();
        var w = factory.empty(id);
        model.addAttribute("wish",w);
        return "redirect:createWishForm";
    }

    @PostMapping("wish/create")
    public String createPost(@ModelAttribute("wish") Wish wish){
        var id = session.getAttribute("wishlistId").toString();
        if(dbManager.addWish(id,wish))
            return "redirect:wishes";
        return "redirect:err";
    }

    @GetMapping("wish/removeWish")
    public String removeGet(@RequestParam(value = "id") String id, Model model){
        var w = dbManager.getWishById(id);
        model.addAttribute("wish",w);
        return "redirect:removeWishConfirmation";
    }

    @PostMapping("wish/removeWish")
    public String removeGet(@ModelAttribute("wish") Wish wish){
        if(dbManager.removeWish(wish.getId()))
            return "redirect:wish/wishes";
        return "redirect:err";
    }

    @GetMapping("wish/update")
    public String updateGet(@RequestParam(value = "id") String id, Model model){
        var w = dbManager.getWishById(id);
        model.addAttribute("wish",w);
        return "redirect:updateWishForm";
    }

    @PostMapping("wish/update")
    public String updateGet(@ModelAttribute("wish") Wish wish){
        if(dbManager.updateWish(wish))
            return "wish/wishes";
        return "redirect:err";
    }

    public String reserve(@RequestParam String name, String id){
        if(dbManager.reserveWish(id,name))
            return "redirect:wish/wishes";
        return "redirect;err";
    }

    @Autowired
    private IDbManager dbManager;
    @Autowired
    private IWishFactory factory;

    @Autowired
    private HttpSession session;
}
