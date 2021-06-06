package com.card.management.main.repository;

import com.card.management.main.models.Card;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Integer> {
    
}
