package com.example.Hanpoon.controller;

import com.example.Hanpoon.dto.SignupRequest;
import com.example.Hanpoon.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 인증 관련 API(회원가입, 로그인)
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    // 회원가입 API
    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest request)
    {
        userService.signup(request);
        return "회원가입 성공";
    }
}
