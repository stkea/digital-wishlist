package com.example.wishlistproject.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ErrorController {
    @GetMapping("bad_input")
    public String badInput(){
        return "Error/bad_input";
    }

    @GetMapping("invalid_share_key/{key}")
    public String badKey(@PathVariable String key, Model model){
        model.addAttribute("key",key);
        return "Error/invalid_share_key";
    }

    @GetMapping("key_not_found/{key}")
    public String keyNotFound(@PathVariable String key, Model model){
        model.addAttribute("key",key);
        return "Error/key_not_found";
    }
}
