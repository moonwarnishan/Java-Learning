package com.example.crudDemo.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider
{
    @Value("{jwt.secret}")
    private String secretKey;

    @Value(("jwt.expiration"))
    private long validityInMilliseconds;

    public String generateToken(String username)
    {
        Date now = new Date();
        Date validity = new Date(now.getTime()+validityInMilliseconds);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS512,secretKey)
                .compact();
    }

    public boolean validateToken(String token)
    {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        }
        catch (Exception ex)
        {
            return false;
        }
    }

    public String getUsernameFromToken(String token)
    {
        Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

}
