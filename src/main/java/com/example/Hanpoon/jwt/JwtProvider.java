package com.example.Hanpoon.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

// JWT 생성/검증/파싱 담당 클래스

@Component
@RequiredArgsConstructor
public class JwtProvider {
    private final JwtProperties jwtProperties;

    // Secret Key를 HMAC 방식으로 변환
    private SecretKey getSigningKey()
    {
        return Keys.hmacShaKeyFor(jwtProperties.getSecret().getBytes(StandardCharsets.UTF_8));
    }

    // JWT 생성
    public String generateToken(String email)
    {
        long now = System.currentTimeMillis();

        return Jwts.builder().subject(email).issuedAt(new Date(now))
                .expiration(new Date(now + jwtProperties.getExpiration()))
                .signWith(getSigningKey())
                .compact();
    }

    // JWT 파싱
    private Claims parseClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    // JWT에서 이메일 추출
    public String getEmail(String token)
    {
        return parseClaims(token).getSubject();
    }

    // 토큰 유효성 검사
    public boolean validateToken(String token)
    {
        try {
            parseClaims(token);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}
