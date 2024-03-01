package com.example.undercooked.service;

import com.example.undercooked.model.IngredientMaterial;
import com.example.undercooked.model.PantryItem;
import com.example.undercooked.model.user.NewPantryItemRequest;
import com.example.undercooked.model.user.UserEntity;
import com.example.undercooked.repository.IngredientMaterialRepository;
import com.example.undercooked.repository.PantryItemRepository;
import com.example.undercooked.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final IngredientMaterialRepository ingredientMaterialRepository;
    private final PantryItemRepository pantryItemRepository;

    public UserService(UserRepository userRepository, IngredientMaterialRepository ingredientMaterialRepository, PantryItemRepository pantryItemRepository) {
        this.userRepository = userRepository;
        this.ingredientMaterialRepository = ingredientMaterialRepository;
        this.pantryItemRepository = pantryItemRepository;
    }


    public void createUser(UserEntity user) {
        if (userRepository.getUserEntityByName(user.getName()).isEmpty()) {
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException(String.format("User already exists: %s", user.getName()));
        }
    }

    public List<PantryItem> getPantryItemsByUserId(String userName) {
        if (userRepository.getUserEntityByName(userName).isPresent()) {
            UserEntity user = userRepository.getUserEntityByName(userName).get();
            return user.getPantry();
        } else {
            throw new IllegalArgumentException((String.format("User not found: %s", userName)));
        }

    }

    public void addPantryItem(String userName, NewPantryItemRequest pantryItemRequest) {
        IngredientMaterial ingredientMaterial = ingredientMaterialRepository.getReferenceById((long) pantryItemRequest.id());

        PantryItem newPantryItem = new PantryItem(ingredientMaterial, pantryItemRequest.amount(), pantryItemRequest.unit());
        pantryItemRepository.save(newPantryItem);

        if (userRepository.getUserEntityByName(userName).isPresent()) {
            UserEntity user = userRepository.getUserEntityByName(userName).get();
            user.addPantryItem(newPantryItem);
            userRepository.save(user);
        }
    }
}
