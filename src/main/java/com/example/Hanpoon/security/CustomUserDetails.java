package com.example.Hanpoon.security;

// Spring Security가 사용하는 로그인 사용자 정보

import ch.qos.logback.core.sift.AppenderFactoryUsingSiftModel;
import com.example.Hanpoon.domain.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class CustomUserDetails implements UserDetails {
    private final User user;    // 실제 회원 엔티티
    
    // 권한 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return List.of(() -> user.getRole().name());
    }

    // 비밀번호 반환
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // 이메일 로그인 아이디 반환
    @Override
    public String getUsername() {
        return user.getEmail();
    }
}
