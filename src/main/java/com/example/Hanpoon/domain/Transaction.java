package com.example.Hanpoon.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    private Long amount;
    private Long balanceAfter;
    private String createdAt;

    public Transaction(String accountNumber, TransactionType type, Long amount, Long balanceAfter) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.createdAt = String.valueOf(System.currentTimeMillis());
    }
}
