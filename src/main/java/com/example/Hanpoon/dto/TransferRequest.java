package com.example.Hanpoon.dto;

import lombok.Getter;

@Getter
public class TransferRequest {
    private String fromAccount;
    private String toAccount;
    private Long amount;
}
