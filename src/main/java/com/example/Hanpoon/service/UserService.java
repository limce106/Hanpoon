package com.example.Hanpoon.service;

import com.example.Hanpoon.common.exception.DuplicateEmailException;
import com.example.Hanpoon.domain.User;
import com.example.Hanpoon.domain.Role;
import com.example.Hanpoon.dto.SignupRequest;
import com.example.Hanpoon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

// 사용자 관련 비즈니스 로직 처리
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;    // DB 접근 객체
    private  final PasswordEncoder passwordEncoder; // 비밀번호 암호화 객체

    // 회원가입 처리 로직
    public void signup(SignupRequest request)
    {
        // 이메일 중복 체크
        if(userRepository.findByEmail(request.getEmail()).isPresent())
        {
            throw new DuplicateEmailException("이미 존재하는 이메일입니다.");
        }

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = new User(
                request.getEmail(),
                encodedPassword,
                request.getName(),
                Role.USER
        );
    }
}
