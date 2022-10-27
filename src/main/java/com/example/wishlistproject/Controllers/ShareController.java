package com.example.wishlistproject.Controllers;

import com.example.wishlistproject.Repository.Sharing.ISharingTokenPersistence;
import com.example.wishlistproject.Services.Factories.Sharing.IShareTokenFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShareController {
    @GetMapping("share/sharewishlist")
    public String shareWishlist(@RequestParam String id, Model model){
        var token = tokenFactory.token(id);
        if(tokenPersistence.persist(token))
            return "redirect:err";
        model.addAttribute("shareLink",token.getTokenValue());
        return "success";
    }

    @Autowired
    private IShareTokenFactory tokenFactory;
    private ISharingTokenPersistence tokenPersistence;
}
