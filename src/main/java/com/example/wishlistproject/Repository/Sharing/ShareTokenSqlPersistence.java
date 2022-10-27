package com.example.wishlistproject.Repository.Sharing;

import com.example.wishlistproject.Models.Sharing.ShareToken;
import org.springframework.stereotype.Service;

@Service
public class ShareTokenSqlPersistence implements ISharingTokenPersistence{
    @Override
    public boolean persist(ShareToken token) {
        return false;
    }
}
