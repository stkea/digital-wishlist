package com.example.wishlistproject.Services.Factories.Sharing;

import com.example.wishlistproject.Models.Sharing.ShareToken;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class LocalhostLetterToken implements IShareTokenFactory {
    @Override
    public ShareToken token(String id) {
        var tokenId = UUID.randomUUID().toString();
        var tokenValue = generate(seed());
        var tokenLink = baseUrl + tokenValue;
        var token = new ShareToken(tokenId,id,tokenLink,tokenValue);
        return token;
    }

    @Override
    public boolean validateKey(String key) {
        return Pattern.matches("^[A-Z]{0,9}$",key);
    }

    private int seed(){
        var s = Math.random()*127000000;
        return (int) s;
    }

    public String generate(int seed){
        var numAsString = String.valueOf(seed);
        var builder = new StringBuilder();
        for (int i = 0; i < numAsString.length(); i++) {
            var c = numAsString.charAt(i);
            builder.append(toLetter(c));
        }
        return builder.toString();
    }

    private char toLetter(char d){
        var startVal = 65;
        int shift = (int) (16 * Math.random());
        var aShift = (int) d - 48;
        var tShift = shift + aShift;
        var newVal = startVal + tShift;
        return (char) newVal;
    }

    private final String baseUrl = "http://localhost:8080/share/";
}
