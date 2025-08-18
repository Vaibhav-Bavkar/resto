package com.example.resto.service;

import com.example.resto.repository.RestaurantRepo;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    private RestaurantRepo restaurantRepo;

    RestaurantService(RestaurantRepo restaurantRepo){
        this.restaurantRepo = restaurantRepo;
    }
}
