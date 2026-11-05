package com.library.service;

import com.library.dtos.UserRegistrationDTO;
import com.library.entities.User;
import com.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(String username, String password) {

        return userRepository.findByUserNameIgnorecase(username)
                .filter(u -> u.getPassword().equals(password)).orElseThrow(()-> new RuntimeException("Invalid Credentials"));
    }

    @Override
    public boolean register(UserRegistrationDTO request) {
        if (userRepository.findByUserNameIgnorecase(request.getUsername()).isPresent())
        {
            throw new RuntimeException("User already exists");
        }

        User.builder().username(request.getUsername()).password(request.getPassword()).designation("user").build();
        return false;
    }
}
