package com.example.Hanpoon.repository;

import com.example.Hanpoon.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Hanpoon.domain.Account;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUser(User user);
}
