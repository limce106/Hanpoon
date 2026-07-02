package com.example.Hanpoon.dto;

import lombok.Getter;

@Getter
public class TransactionRequest {
    private String accountNumber;
    private Long amount;
}
