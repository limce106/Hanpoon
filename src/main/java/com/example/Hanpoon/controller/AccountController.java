package com.example.Hanpoon.controller;

import com.example.Hanpoon.dto.AccountCreateResponse;
import com.example.Hanpoon.dto.TransactionRequest;
import com.example.Hanpoon.dto.TransferRequest;
import com.example.Hanpoon.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping
    public AccountCreateResponse createAccount(@RequestHeader("Authorization") String token)
    {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return accountService.createAccount(email);
    }

    @GetMapping
    public List<AccountCreateResponse> getMyAccounts()
    {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return accountService.getMyAccounts(email);
    }

    @PostMapping("/deposit")
    public void deposit(@RequestBody TransactionRequest request)
    {
        accountService.deposit(request);
    }

    @PostMapping("/withdraw")
    public void withdraw(@RequestBody TransactionRequest request)
    {
        accountService.withdraw(request);
    }

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequest request)
    {
        accountService.transfer(request);
    }
}
