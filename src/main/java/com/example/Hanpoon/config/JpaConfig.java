package com.example.Hanpoon.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// JPA 기능 중 "자동 시간 기록 기능"을 활성화하는 설정 클래스
@EnableJpaAuditing
@Configuration
public class JpaConfig {
}
