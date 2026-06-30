package com.example.Hanpoon.dto;

import lombok.Getter;

// 회원가입 요청 데이터를 담는 DTO (Controller + Service로 전달되는 데이터)
@Getter
public class SignupRequest {
    private String email;
    private String password;
    private String name;
}
