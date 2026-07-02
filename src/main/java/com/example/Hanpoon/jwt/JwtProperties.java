package com.example.Hanpoon.jwt;

// application.properties의 JWT 설정값을 읽어오는 클래스

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class JwtProperties {
    // JWT 비밀키
    @Value("${jwt.secret}")
    private String secret;

    // JWT 만료 시간(ms)
    @Value("${jwt.expiration}")
    private long expiration;
}
