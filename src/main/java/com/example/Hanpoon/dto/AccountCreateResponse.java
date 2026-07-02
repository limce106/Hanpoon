package com.example.Hanpoon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AccountCreateResponse {
    private String accountNumber;
    private Long balance;
}
