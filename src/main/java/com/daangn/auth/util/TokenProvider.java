package com.daangn.auth.util;

import com.daangn.auth.exceptions.InvalidTokenException;
import com.daangn.auth.exceptions.TokenExpiredException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

/**
 * 토큰 생성 및 검증
 */
@RequiredArgsConstructor
@Component
public class TokenProvider implements InitializingBean {

    @Value("${jwt.token.secret-key}")
    private String secretKey;

    @Value("${jwt.token.expired-time}")
    private long validityInMilliseconds;

    private Key key;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String createToken(String subject) {
        Claims claims = Jwts.claims().setSubject(subject);
        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(validity)
                .signWith(key)
                .compact();
    }

    public String getIdFromToken(String authToken) {
        Claims claims = getClaims(authToken);
        return claims.get("id", String.class);
    }

    public boolean validateToken(String authToken) {
        try {
            Jws<Claims> claim = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(authToken);
            return true;
        } catch (ExpiredJwtException e) {
            throw new TokenExpiredException();
        } catch (JwtException e) {
            throw new InvalidTokenException();
        }
    }

    private Claims getClaims(String authToken) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(authToken)
                .getBody();
    }

}