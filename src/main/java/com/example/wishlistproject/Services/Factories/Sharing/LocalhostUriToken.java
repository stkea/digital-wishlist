package com.example.wishlistproject.Services.Factories.Sharing;

import com.example.wishlistproject.Models.Sharing.ShareToken;

import java.util.UUID;

public class LocalhostUriToken implements IShareTokenFactory {
    @Override
    public ShareToken token(String id) {
        var value = String.format("http://localhost:8080/wish/wishes?wishlistId=%s",id);
        var tokenId = UUID.randomUUID().toString();
        var token = new ShareToken(tokenId, value, id, "");
        return token;
    }
}
