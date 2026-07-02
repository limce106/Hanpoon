package com.example.Hanpoon.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 모든 API의 공통 응답 형식
// success: 요청 성공 여부
// message: 사용자에게 전달할 메시지
// data: 실제 데이터

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
    private final boolean success;
    private final String message;
    private final T data;   // 회원가입이면 null, 조회면 조회 결과
    
    // 성공 응답 생성
    public static <T> ApiResponse<T> success(String message, T data)
    {
        return new ApiResponse<T>(true, message, data);
    }

    // 실패 응답 생성
    public static ApiResponse<Void> fail(String message)
    {
        return new ApiResponse<>(false, message, null);
    }
}
