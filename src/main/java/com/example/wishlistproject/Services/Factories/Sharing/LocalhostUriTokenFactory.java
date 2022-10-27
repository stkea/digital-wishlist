package com.example.wishlistproject.Services.Factories.Sharing;

/*
    A simple service that takes a wishlist id and creates
    an uri on the forms: http://localhost:8080/wish/wishes?={wishlistId}
 */

import com.example.wishlistproject.Models.Sharing.ShareToken;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LocalhostUriTokenFactory implements IShareTokenFactory{
    @Override
    public ShareToken token(String id) {
        var value = String.format("http://localhost:8080/wish/wishes?wishlistId=%s",id);
        var tokenId = UUID.randomUUID().toString();
        var token = new ShareToken(tokenId, value, id);
        return token;
    }
}
