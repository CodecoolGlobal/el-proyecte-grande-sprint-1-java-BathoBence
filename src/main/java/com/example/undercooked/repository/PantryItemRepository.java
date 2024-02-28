package com.example.undercooked.repository;

import com.example.undercooked.model.Ingredient;
import com.example.undercooked.model.PantryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PantryItemRepository extends JpaRepository<PantryItem, Long> {
}
