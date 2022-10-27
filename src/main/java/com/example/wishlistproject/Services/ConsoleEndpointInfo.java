package com.example.wishlistproject.Services;

public class ConsoleEndpointInfo {
    public static void printInfo(){
        System.out.println("""
                
                Welcome to KEA Digital Wishlist powered by Thymeleaf and Spring
                
                End points:
                
                Root: http://localhost:8080/
                Wishlists overview: http://localhost:8080/wishlists
                Wishes overview: http://localhost:8080/wish/wishes?wishlistId="hej med dig"
                """);
    }
}
