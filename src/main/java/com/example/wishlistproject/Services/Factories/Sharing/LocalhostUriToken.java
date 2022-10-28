package com.example.wishlistproject.Services.Factories.Sharing;

import com.example.wishlistproject.Models.Sharing.ShareToken;

import java.util.UUID;
import java.util.regex.Pattern;

public class LocalhostUriToken implements IShareTokenFactory {
    @Override
    public ShareToken token(String id) {
        var value = String.format("http://localhost:8080/wish/wishes?wishlistId=%s",id);
        var tokenId = UUID.randomUUID().toString();
        var token = new ShareToken(tokenId, value, id, "");
        return token;
    }

    @Override
    public boolean validateKey(String key) {
        return Pattern.matches("^[\\d,a-f]{8}-[\\d,a-f]{4}-[\\d,a-f]{4}-[\\d,a-f]{4}-[\\d,a-f]{12}$",
                key);
    }
}
