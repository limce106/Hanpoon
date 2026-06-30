package com.example.Hanpoon.repository;

import com.example.Hanpoon.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// DB 접근 인터페이스
public interface UserRepository extends JpaRepository<User, Long> {
    // 이메일로 사용자 찾기
    Optional<User> findByEmail(String email);
}
