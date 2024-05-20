package com.example.undercooked.controller;

import com.example.undercooked.dto.RecipeInfoDTO;
import com.example.undercooked.model.PantryItem;
import com.example.undercooked.model.user.*;
import com.example.undercooked.security.jwt.JwtUtils;
import com.example.undercooked.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public UserController(UserService userService, PasswordEncoder encoder, AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.userService = userService;
        this.encoder = encoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> createUser(@RequestBody UserRequest request) {
        UserEntity user = new UserEntity(request.name(), request.email(), encoder.encode(request.password()));
        user.addRole(Role.ROLE_USER);
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public JwtResponse authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.name(), loginRequest.password())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        User userDetails = (User) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        JwtResponse response = new JwtResponse(jwt, userDetails.getUsername(), roles);

        return response;
    }

    private String extractTokenFromRequest(HttpServletRequest request) {
        Optional<Cookie> accessTokenCookie = Optional.ofNullable(request.getCookies())
                .flatMap(cookies ->
                        List.of(cookies)
                                .stream()
                                .filter(cookie -> cookie.getName().equals("accessToken"))
                                .findFirst());

        return accessTokenCookie.map(Cookie::getValue).orElse(null);
    }


    @GetMapping("/pantry")
    @PreAuthorize("hasRole('USER')")
    public List<PantryItem> getPantryByUser(HttpServletRequest request) {
        String userName = getUserNameFromToken(request);
        List<PantryItem> userPantry = userService.getPantryItemsByUserName(userName);

        return userPantry;
    }

    @PostMapping("/pantry")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> addPantryItem(HttpServletRequest request, @RequestBody NewPantryItemRequest pantryItemRequest) {
        String userName = getUserNameFromToken(request);
        PantryItem pantryItem =userService.addPantryItem(userName, pantryItemRequest);
        return ResponseEntity.ok(pantryItem);
    }

    @GetMapping("/recipes")
    @PreAuthorize("hasRole('USER')")
    public List<RecipeInfoDTO> getAvailableRecipesBasedOnUserPantryItems(HttpServletRequest request) {
        String userName = getUserNameFromToken(request);
        List<RecipeInfoDTO> recipes = userService.getAvailableRecipesBasedOnUserPantryItems(userName);

        return recipes;
    }

    private String getUserNameFromToken(HttpServletRequest request) {
        String token = extractTokenFromRequest(request);
        return jwtUtils.getUserNameForJwtToken(token);
    }

}
