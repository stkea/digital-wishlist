package com.example.wishlistproject.Services.Factories.Sharing;

import com.example.wishlistproject.Models.Sharing.ShareToken;

public interface IShareTokenFactory {
    ShareToken token(String id);
    boolean validateKey(String key);
}
