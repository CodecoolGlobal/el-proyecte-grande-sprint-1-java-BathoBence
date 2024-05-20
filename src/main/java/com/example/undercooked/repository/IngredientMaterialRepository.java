package com.example.undercooked.repository;

import com.example.undercooked.model.IngredientMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientMaterialRepository extends JpaRepository<IngredientMaterial, Long> {
}
