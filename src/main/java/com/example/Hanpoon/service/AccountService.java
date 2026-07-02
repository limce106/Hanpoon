package com.example.Hanpoon.service;

import com.example.Hanpoon.domain.Account;
import com.example.Hanpoon.domain.User;
import com.example.Hanpoon.dto.AccountCreateResponse;
import com.example.Hanpoon.repository.AccountRepository;
import com.example.Hanpoon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountCreateResponse createAccount(String email)
    {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("유저 없음"));

        String accountNumber = "1106-" + System.currentTimeMillis();
        Account account = new Account(accountNumber, user);
        accountRepository.save(account);

        return new AccountCreateResponse(accountNumber, 0L);
    }
}
