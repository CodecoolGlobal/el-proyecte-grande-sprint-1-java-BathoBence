package com.example.undercooked.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenPantryService {
    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(OpenPantryService.class);

    public OpenPantryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}
