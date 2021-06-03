package com.card.management.main.repository;

import com.card.management.main.models.Transaction;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    
}
