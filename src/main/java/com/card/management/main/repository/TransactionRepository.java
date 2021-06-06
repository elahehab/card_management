package com.card.management.main.repository;

import com.card.management.main.models.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    
}
