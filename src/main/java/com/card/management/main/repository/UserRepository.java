package com.card.management.main.repository;

import java.util.List;

import com.card.management.main.models.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    
    List<User> findByUsernameAndPassword(String username, String password);
}
