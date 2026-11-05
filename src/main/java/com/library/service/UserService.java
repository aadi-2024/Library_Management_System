package com.library.service;

import com.library.dtos.UserRegistrationDTO;
import com.library.entities.User;

public interface UserService {

    User login(String username, String password);
    boolean register(UserRegistrationDTO request);
}
