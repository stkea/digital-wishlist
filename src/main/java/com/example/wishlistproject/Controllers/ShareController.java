package com.example.wishlistproject.Controllers;

import com.example.wishlistproject.Repository.Sharing.IDbShareTokenFetcher;
import com.example.wishlistproject.Repository.Sharing.ISharingTokenPersistence;
import com.example.wishlistproject.Services.Factories.Sharing.IShareTokenFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShareController {
    @GetMapping("share/sharewishlist")
    public String shareWishlist(@RequestParam String id, Model model){
        var token = tokenFactory.token(id);
        if(tokenPersistence.persist(token))
            return "redirect:err";
        model.addAttribute("shareLink",token.getTokenLink());
        return "success";
    }

    @GetMapping("share/shareToken/{tokenKey}")
    public String handleToken(@PathVariable String tokenKey){
        if(!tokenFactory.validateKey(tokenKey))
            return "redirect:invalid_share_key";
        var token = tokenFetcher.get(tokenKey);
        if(token != null)
            return "redirect:/wish/wishes?wishlistId=" + token.getWishlistId();
        return "redirect:key_not_found";
    }

    @Autowired
    private IShareTokenFactory tokenFactory;

    @Autowired
    private ISharingTokenPersistence tokenPersistence;

    @Autowired
    private IDbShareTokenFetcher tokenFetcher;
}
