package com.example.undercooked.service;

import com.example.undercooked.dto.RecipeInfoDTO;
import com.example.undercooked.model.IngredientMaterial;
import com.example.undercooked.model.PantryItem;
import com.example.undercooked.model.user.NewPantryItemRequest;
import com.example.undercooked.model.user.UserEntity;
import com.example.undercooked.repository.IngredientMaterialRepository;
import com.example.undercooked.repository.PantryItemRepository;
import com.example.undercooked.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final IngredientMaterialRepository ingredientMaterialRepository;
    private final PantryItemRepository pantryItemRepository;
    private final RecipeService recipeService;

    public UserService(UserRepository userRepository, IngredientMaterialRepository ingredientMaterialRepository, PantryItemRepository pantryItemRepository, RecipeService recipeService) {
        this.userRepository = userRepository;
        this.ingredientMaterialRepository = ingredientMaterialRepository;
        this.pantryItemRepository = pantryItemRepository;
        this.recipeService = recipeService;
    }


    public void createUser(UserEntity user) {
        if (userRepository.getUserEntityByName(user.getName()).isEmpty()) {
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException(String.format("User already exists: %s", user.getName()));
        }
    }

    public List<PantryItem> getPantryItemsByUserName(String userName) {
        if (userRepository.getUserEntityByName(userName).isPresent()) {
            UserEntity user = userRepository.getUserEntityByName(userName).get();
            return user.getPantry();
        } else {
            throw new IllegalArgumentException((String.format("User not found: %s", userName)));
        }

    }

    public void addPantryItem(String userName, NewPantryItemRequest pantryItemRequest) throws HttpClientErrorException.BadRequest {
        IngredientMaterial ingredientMaterial = ingredientMaterialRepository.getReferenceById((long) pantryItemRequest.id());

        if (pantryItemRequest.amount() <= 0) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Amount must be greater than zero.");
        }
        PantryItem newPantryItem = new PantryItem(ingredientMaterial, pantryItemRequest.amount(), pantryItemRequest.unit());
        pantryItemRepository.save(newPantryItem);

        if (userRepository.getUserEntityByName(userName).isPresent()) {
            UserEntity user = userRepository.getUserEntityByName(userName).get();
            user.addPantryItem(newPantryItem);
            userRepository.save(user);
        }
    }

    public List<RecipeInfoDTO> getAvailableRecipesBasedOnUserPantryItems(String userName) {
        List<PantryItem> userPantryItems = getPantryItemsByUserName(userName);
        return recipeService.getRecipesByUserPantryItems(userPantryItems);
    }
}
