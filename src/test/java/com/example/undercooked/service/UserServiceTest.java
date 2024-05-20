package com.example.undercooked.service;

import com.example.undercooked.model.FoodCategory;
import com.example.undercooked.model.IngredientMaterial;
import com.example.undercooked.model.PantryItem;
import com.example.undercooked.model.user.NewPantryItemRequest;
import com.example.undercooked.model.user.UserEntity;
import com.example.undercooked.repository.IngredientMaterialRepository;
import com.example.undercooked.repository.PantryItemRepository;
import com.example.undercooked.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private IngredientMaterialRepository ingredientMaterialRepository;
    @Mock
    private PantryItemRepository pantryItemRepository;
    @Mock
    private RecipeService recipeService;
    @InjectMocks
    private UserService userService;

    @Test
    void testCreateUser_UserDoesntExist() {
        UserEntity user = new UserEntity("Test", "test@test.hu", "Test1234");

        Mockito.when(userRepository.getUserEntityByName(user.getName())).thenReturn(Optional.empty());

        userService.createUser(user);

        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testCreateUser_UserExists() {
        UserEntity user = new UserEntity("Test", "test@test.hu", "Test1234");

        Mockito.when(userRepository.getUserEntityByName(user.getName())).thenReturn(Optional.of(user));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> userService.createUser(user));
        assertEquals("User already exists: Test", exception.getMessage());
    }

    @Test
    void tesGetPantryItemsByUserName_userExistAndPantryIsEmpty() {
        UserEntity user = new UserEntity("Test", "test@test.hu", "Test1234");

        Mockito.when(userRepository.getUserEntityByName(user.getName())).thenReturn(Optional.of(user));

        List<PantryItem> result = userService.getPantryItemsByUserName(user.getName());

        assertTrue(result.isEmpty());
    }

    @Test
    void tesGetPantryItemsByUserName_userExistAndPantryHasItems() {
        UserEntity user = new UserEntity("Test", "test@test.hu", "Test1234");

        FoodCategory pasta = new FoodCategory("pasta");
        FoodCategory dairy = new FoodCategory("dairy");
        IngredientMaterial milk = new IngredientMaterial("Milk", dairy);
        IngredientMaterial spaghetti = new IngredientMaterial("Spaghetti", pasta);
        PantryItem pantryItem1 = new PantryItem(milk, 2, "l");
        PantryItem pantryItem2 = new PantryItem(spaghetti, 2, "kg");
        user.addPantryItem(pantryItem1);
        user.addPantryItem(pantryItem2);

        Mockito.when(userRepository.getUserEntityByName(user.getName())).thenReturn(Optional.of(user));

        List<PantryItem> result = userService.getPantryItemsByUserName(user.getName());

        assertTrue(result.containsAll(List.of(pantryItem1, pantryItem2)));
    }

    @Test
    void tesGetPantryItemsByUserName_userDoesntExist() {
        String userName = "Test";

        Mockito.when(userRepository.getUserEntityByName(userName)).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> userService.getPantryItemsByUserName(userName));
        assertEquals("User not found: Test", exception.getMessage());
    }

    @Test
    void testAddPantryItem_AmountIsLowerThanZero() {
        String userName = "Test";
        int amount = -1;
        NewPantryItemRequest pantryItemRequest = new NewPantryItemRequest(1, "l", amount);

        assertThrows(HttpClientErrorException.class, () -> userService.addPantryItem(userName, pantryItemRequest));

    }

}