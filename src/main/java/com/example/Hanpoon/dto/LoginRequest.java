package com.example.Hanpoon.dto;

// 로그인 요청 데이터를 담는 DTO

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class LoginRequest {
    //로그인 이메일
    @NotBlank(message = "이메일은 필수입니다.")
    @Email(message = "이메일 형식이 올바르지 않습니다.")
    private String email;

    // 로그인 비밀전호
    @NotBlank(message = "비밀번호는 필수입니다.")
    private String password;
}
