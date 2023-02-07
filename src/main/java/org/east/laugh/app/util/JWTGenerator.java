package org.east.laugh.app.util;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.io.Serial;
import java.util.Date;

@Component
public class JWTGenerator {

//    @Value("${jwt.secret}")
//    private String secret;

    @Value("${jwt.expire}")
    private long expire;

    public static final SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    public JWTGenerator() {
        System.out.println(Encoders.BASE64.encode(key.getEncoded()));
    }

    public String GenerateJwt(String identity){
//        key=Keys.secretKeyFor(SignatureAlgorithm.HS512);
        Date date = new Date();
        return Jwts.builder()
                .setHeaderParam("type","JWT")
                .setSubject(identity)
                .setIssuedAt(date)
                .setExpiration(new Date(date.getTime()+1000*expire))
                .signWith(key)
                .compact();

    }

    public Boolean ParseJwt(String token,String identity){
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJwt(token).getBody().getSubject().equals(identity);
    }
}
