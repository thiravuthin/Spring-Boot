package com.example.springboot.security.security_jwt.config;

import com.google.common.base.Function;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtService {

    private static final String SECRET_KEY =  "5848dcafd408008890a8424d89cc2218fa294d899739b413066870d28c137466";
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
        /* getSubject = email or password */
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInkey()) /* */
                .build()
                .parseClaimsJwt(token)
                .getBody();
    }

    private Key getSignInkey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(Map<String, Object> extractClaims, UserDetails userDetails){
     return Jwts
             .builder()
             .setClaims(extractClaims)
             .setSubject(userDetails.getUsername())
             .setIssuedAt(new Date(System.currentTimeMillis()))
             .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
             .signWith(getSignInkey(), SignatureAlgorithm.ES256)
             .compact();
    }
    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(), userDetails);
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        final String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired( String token){
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

}