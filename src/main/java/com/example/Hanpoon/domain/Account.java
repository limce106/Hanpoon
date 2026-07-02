package com.example.Hanpoon.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 계좌번호
    @Column(nullable = false, unique = true)
    private String accountNumber;

    // 잔액
    private Long balance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Account(String accountNumber, User user)
    {
        this.accountNumber = accountNumber;
        this.balance = 0L;
        this.user = user;
    }

    public void deposit(Long amount)
    {
        this.balance += amount;
    }

    public void withdraw(Long amount)
    {
        this.balance -= amount;
    }
}
