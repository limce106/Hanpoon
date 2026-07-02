package com.example.Hanpoon.repository;

import com.example.Hanpoon.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountNumberOrderByIdDesc(String accountNumber);
}
