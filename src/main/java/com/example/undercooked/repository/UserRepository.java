package com.example.undercooked.repository;

import com.example.undercooked.model.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> getUserEntityByName(String name);
}
