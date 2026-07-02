package com.example.Hanpoon.service;

import com.example.Hanpoon.common.exception.AccountNotFoundException;
import com.example.Hanpoon.common.exception.InsufficientBalanceException;
import com.example.Hanpoon.common.exception.UserNotFoundException;
import com.example.Hanpoon.domain.Account;
import com.example.Hanpoon.domain.Transaction;
import com.example.Hanpoon.domain.TransactionType;
import com.example.Hanpoon.domain.User;
import com.example.Hanpoon.dto.AccountCreateResponse;
import com.example.Hanpoon.dto.TransactionRequest;
import com.example.Hanpoon.dto.TransferRequest;
import com.example.Hanpoon.repository.AccountRepository;
import com.example.Hanpoon.repository.TransactionRepository;
import com.example.Hanpoon.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    public AccountCreateResponse createAccount(String email)
    {
        // 사용자 조회
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("유저 없음"));

        // 계좌번호 생성
        String accountNumber = "1106-" + System.currentTimeMillis();
        Account account = new Account(accountNumber, user);
        accountRepository.save(account);

        return new AccountCreateResponse(accountNumber, 0L);
    }

    public List<AccountCreateResponse> getMyAccounts(String email)
    {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("유저 없음"));

        List<Account> accounts = accountRepository.findByUser(user);

        return accounts.stream().map(
                acc -> new AccountCreateResponse(acc.getAccountNumber(), acc.getBalance())).toList();
    }

    // 입금
    @Transactional
    public void deposit(TransactionRequest request)
    {
        Account account = accountRepository.findByAccountNumber(request.getAccountNumber())
                .orElseThrow(() -> new AccountNotFoundException("계좌 없음"));

        account.deposit(request.getAmount());

        transactionRepository.save(
                new Transaction(
                        account.getAccountNumber(),
                        TransactionType.DEPOSIT,
                        request.getAmount(),
                        account.getBalance()
                )
        );
    }

    // 출금
    @Transactional
    public void withdraw(TransactionRequest request)
    {
        Account account = accountRepository.findByAccountNumber(request.getAccountNumber())
                .orElseThrow(() -> new AccountNotFoundException("계좌 없음"));

        if(account.getBalance() < request.getAmount())
        {
            throw new InsufficientBalanceException("잔액 부족");
        }

        account.withdraw(request.getAmount());

        transactionRepository.save(
                new Transaction(
                        account.getAccountNumber(),
                        TransactionType.WITHDRAW,
                        request.getAmount(),
                        account.getBalance()
                )
        );
    }
    
    // 이체
    @Transactional
    public void transfer(TransferRequest request)
    {
        Account from = accountRepository.findByAccountNumber(request.getFromAccount())
                .orElseThrow(() -> new AccountNotFoundException("출금 계좌 없음"));
        
        Account to = accountRepository.findByAccountNumber(request.getToAccount())
                .orElseThrow(() -> new AccountNotFoundException("입금 계좌 없음"));

        if(from.getBalance() < request.getAmount())
        {
            throw new InsufficientBalanceException("잔액 부족");
        }

        from.withdraw(request.getAmount());
        to.deposit(request.getAmount());

        transactionRepository.save(
                new Transaction(
                        from.getAccountNumber(),
                        TransactionType.TRANSFER_OUT,
                        request.getAmount(),
                        from.getBalance()
                )
        );

        transactionRepository.save(
                new Transaction(
                        to.getAccountNumber(),
                        TransactionType.TRANSFER_IN,
                        request.getAmount(),
                        to.getBalance()
                )
        );
    }
    
    // 거래내역 조회
    public List<Transaction> getTransactions(String accountNumber)
    {
        return transactionRepository.findByAccountNumberOrderByIdDesc(accountNumber);
    }
}
