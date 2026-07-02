package com.example.Hanpoon.repository;

import com.example.Hanpoon.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Hanpoon.domain.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUser(User user);
    Optional<Account> findByAccountNumber(String accountNumber);
}
