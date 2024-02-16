package com.example.undercooked.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.undercooked.dto.RecipeInfoDTO;

@RestController
@RequestMapping("/api/user")
public class UserController {
  
  @GetMapping("/recipies")
  public List<RecipeInfoDTO> getRecipies() {
    //....
    return new ArrayList<>();
  }
}
