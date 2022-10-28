package com.example.wishlistproject.Services.Security.SqlProtection.UUIDValidator;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UUIDValidator implements IStringValidator {
    @Override
    public boolean validate(String uuid){
        var result = Pattern.matches("^[\\d,a-f]{8}-[\\d,a-f]{4}-[\\d,a-f]{4}-[\\d,a-f]{4}-[\\d,a-f]{12}$",
                uuid);
        return result;
    }
}
