package com.example.Hanpoon.controller;

import com.example.Hanpoon.common.response.ApiResponse;
import com.example.Hanpoon.dto.LoginRequest;
import com.example.Hanpoon.dto.LoginResponse;
import com.example.Hanpoon.dto.SignupRequest;
import com.example.Hanpoon.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ApiResponse<Void>> signup(@Valid @RequestBody SignupRequest request)
    {
        userService.signup(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ApiResponse.success("회원가입이 완료되었습니다.", null)
        );
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request)
    {
        String token = userService.login(request);
        return new LoginResponse(token);
    }
}
