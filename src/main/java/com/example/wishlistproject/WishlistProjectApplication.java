package com.example.wishlistproject;

import com.example.wishlistproject.Services.ConsoleEndpointInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WishlistProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WishlistProjectApplication.class, args);
        ConsoleEndpointInfo.printInfo();
    }

}
