package com.example.undercooked.controller;

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

import java.util.Arrays;
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
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.name(), loginRequest.password())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        User userDetails = (User) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getUsername(), roles));
    }


    @GetMapping("/pantry")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> getPantryByUser(HttpServletRequest request) {
        String token = extractToken(request);
        String userName = jwtUtils.getUserNameForJwtToken(token);

        List<PantryItem> userPantry = userService.getPantryItemsByUserId(userName);
        return ResponseEntity.ok(userPantry);
    }

    @PostMapping("/pantry")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> addPantryItem(HttpServletRequest request, @RequestBody NewPantryItemRequest pantryItemRequest) {
        String token = extractToken(request);
        String userName = jwtUtils.getUserNameForJwtToken(token);
        userService.addPantryItem(userName, pantryItemRequest);
        return ResponseEntity.ok("");
    }

    private String extractToken(HttpServletRequest request) {
        Optional<Cookie> tokenCookie = Optional.ofNullable(request.getCookies())
                .flatMap(cookies ->
                        Arrays.stream(cookies)
                                .filter(cookie -> "accessToken".equals(cookie.getName()))
                                .findFirst());
        return tokenCookie.map(Cookie::getValue).orElse(null);
    }
}
