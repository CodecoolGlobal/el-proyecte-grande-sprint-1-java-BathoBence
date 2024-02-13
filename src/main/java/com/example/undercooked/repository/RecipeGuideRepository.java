package com.example.undercooked.repository;

import com.example.undercooked.model.RecipeGuide;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeGuideRepository extends JpaRepository<RecipeGuide, Long> {
    List<RecipeGuide> findAll();
}
