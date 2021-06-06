package com.card.management.main.repository;

import java.util.List;

import com.card.management.main.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    List<User> findByUsernameAndPassword(String username, String password);
}
