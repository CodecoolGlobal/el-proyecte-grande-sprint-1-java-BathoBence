package com.example.undercooked.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeProviderController {

    @GetMapping("/main")
    public ResponseEntity<?> getMain() {
        return ResponseEntity.ok("Give me food!");
    }
}
