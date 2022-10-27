package com.example.wishlistproject.Repository.Sharing;

import com.example.wishlistproject.Models.Sharing.ShareToken;

public interface ISharingTokenPersistence {
    boolean persist(ShareToken token);
}
