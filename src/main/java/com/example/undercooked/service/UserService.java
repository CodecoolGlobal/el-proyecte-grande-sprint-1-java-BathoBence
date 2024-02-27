package com.example.undercooked.service;

import com.example.undercooked.model.user.UserEntity;
import com.example.undercooked.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void createUser(UserEntity user) {
        if (userRepository.getUserEntityByName(user.getName()).isEmpty()) {
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException(String.format("User already exists: %s", user.getName()));
        }

    }
}
