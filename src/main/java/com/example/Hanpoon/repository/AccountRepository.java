package com.example.Hanpoon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Hanpoon.domain.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
