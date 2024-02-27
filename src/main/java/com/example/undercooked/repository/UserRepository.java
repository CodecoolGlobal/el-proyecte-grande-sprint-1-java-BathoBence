package com.example.undercooked.repository;

import com.example.undercooked.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> getUserEntityByName(String name);

}
