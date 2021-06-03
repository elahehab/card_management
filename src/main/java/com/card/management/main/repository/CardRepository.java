package com.card.management.main.repository;

import com.card.management.main.models.Card;

import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Integer> {
    
}
