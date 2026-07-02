package com.example.Hanpoon.common.exception;

// 이미 존재하는 이메일로 회원가입 시도했을 때 발생하는 예외

public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException(String message)
    {
        super(message);
    }
}
