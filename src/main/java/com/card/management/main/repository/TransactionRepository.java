package com.card.management.main.repository;

import java.util.Date;
import java.util.List;

import com.card.management.main.models.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query(value = "SELECT * FROM transaction where (source_card_id = ?3 or destination_card_id = ?3) and transaction_date > ?1 and transaction_date < ?2", nativeQuery = true)
    public List<Transaction> findCardTransactionsInDateDuration(Date startDate, Date endDate, int cardId);
}
