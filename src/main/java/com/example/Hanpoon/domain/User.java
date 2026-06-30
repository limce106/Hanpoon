package com.example.Hanpoon.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

// 사용자 테이블
@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String email, String password, String name, Role role)
    {
        this.email = email;
        this.password  = password;
        this.name = name;
        this.role = role;
    }
}
