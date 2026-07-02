package com.example.Hanpoon.service;

import com.example.Hanpoon.domain.Account;
import com.example.Hanpoon.domain.User;
import com.example.Hanpoon.dto.AccountCreateResponse;
import com.example.Hanpoon.repository.AccountRepository;
import com.example.Hanpoon.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountCreateResponse createAccount(String email)
    {
        // 사용자 조회
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("유저 없음"));

        // 계좌번호 생성
        String accountNumber = "1106-" + System.currentTimeMillis();
        Account account = new Account(accountNumber, user);
        accountRepository.save(account);

        return new AccountCreateResponse(accountNumber, 0L);
    }

    public List<AccountCreateResponse> getMyAccounts(String email)
    {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("유저 없음"));

        List<Account> accounts = accountRepository.findByUser(user);

        return accounts.stream().map(
                acc -> new AccountCreateResponse(acc.getAccountNumber(), acc.getBalance())).toList();
    }
}
