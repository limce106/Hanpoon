package com.example.Hanpoon.controller;

import com.example.Hanpoon.dto.AccountCreateResponse;
import com.example.Hanpoon.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

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
}
