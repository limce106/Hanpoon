package com.example.Hanpoon.common.exception;

import com.example.Hanpoon.common.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


// 프로젝트 전체의 예외를 처리하는 클래스

@RestControllerAdvice
public class GlobalExceptionHandler {
    // DTO Validation 실패 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationException(
            MethodArgumentNotValidException exception
    ) {
        String message = exception
                .getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        return ResponseEntity.badRequest().body(ApiResponse.fail(message));
    }

    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ApiResponse<Void>> handleDuplicateEmailException(
            DuplicateEmailException exception
    ) {
        // 리소스 충돌 409
        return ResponseEntity.status(409).body(ApiResponse.fail(exception.getMessage()));
    }

    @ExceptionHandler(InvalidLoginException.class)
    public ResponseEntity<ApiResponse<Void>> handleInvalidLoginException(
            InvalidLoginException exception
    ) {
        return ResponseEntity.status(401).body(ApiResponse.fail(exception.getMessage()));
    }
}
