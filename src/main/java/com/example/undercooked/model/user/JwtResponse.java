package com.example.undercooked.model.user;

import java.util.List;

public record JwtResponse (String jwt, String userName, List<String> roles) {
}
