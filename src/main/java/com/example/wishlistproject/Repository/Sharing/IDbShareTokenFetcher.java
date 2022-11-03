package com.example.wishlistproject.Repository.Sharing;

import com.example.wishlistproject.Models.Sharing.ShareToken;

public interface IDbShareTokenFetcher {
    ShareToken get(String tokenKey);
    ShareToken getFromWishlistId(String wishlistID);
}
