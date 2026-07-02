package com.example.Hanpoon.security;

// Spring Security가 로그인 시 사용자 정보를 조회하는 서비스

import com.example.Hanpoon.domain.User;
import com.example.Hanpoon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;    // 회원 조회 Repository

    // 이메일로 회원 조회. Spring Security가 로그인 과정에서 자동으로 호출
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("존재하지 않는 회원입니다."));

        return new CustomUserDetails(user);
    }
}
