package com.example.Hanpoon.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

// 모든 엔티티에 공통으로 들어가는 시간 컬럼을 모아둔 클래스
@MappedSuperclass // 이 클래스는 테이블이 아니라 부모 역할
@EntityListeners(AuditingEntityListener.class) // 시간 자동 감지
@Getter
public abstract class BaseEntity {
    // 생성 시간
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    // 수정 시간
    @LastModifiedDate
    private LocalDateTime updatedAt;
}
