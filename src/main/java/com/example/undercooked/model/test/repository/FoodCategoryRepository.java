package com.example.undercooked.model.test.repository;

import com.example.undercooked.model.test.FoodCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
