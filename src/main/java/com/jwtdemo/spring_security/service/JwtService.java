package com.jwtdemo.spring_security.service;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private String secretKey;
    public JwtService(){
        secretKey=generateSecreteKey();
    }


    public String generateSecreteKey(){
        try{
            KeyGenerator keyGenerator=KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey=keyGenerator.generateKey();
            System.out.println("Secret key --> "+secretKey.toString());
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }


    public String generateToken(String username) {
        Map<String,Object> claims=new HashMap<>();
        String token=Jwts.builder().setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*3))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
        System.out.println("token--->"+token);
        return token;
    }

    private Key getKey() {
        byte[] keyBytes= Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

//    public String getUserName(String token) {
//    }
}
