package com.example.Hanpoon.common.exception;

// 로그인 실패 시 발생하는 예외
// ex) 존재하지 않는 이메일, 비밀번호 불일치

public class InvalidLoginException extends RuntimeException {
    public InvalidLoginException(String message)
    {
        super(message);
    }
}
