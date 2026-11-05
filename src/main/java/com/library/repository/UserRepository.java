package com.library.repository;

import com.library.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public class UserRepository extends JpaRepository<User,Integer> {
    public Optional<User> findByUserNameIgnorecase(String username) {
        return null;
    }
}
