package com.example.resto.service;

import com.example.resto.entity.RestaurantDetails;
import com.example.resto.model.RestaurantRequest;
import com.example.resto.model.RestoUpdateRequest;
import com.example.resto.repository.RestaurantRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class RestaurantService {

    private RestaurantRepo restaurantRepo;

    RestaurantService(RestaurantRepo restaurantRepo){
        this.restaurantRepo = restaurantRepo;
    }

    public String createrestoservice(RestaurantRequest restaurantRequest) {
        RestaurantDetails restaurantDetails=RestaurantDetails.builder()
                .name(restaurantRequest.getName())
                .address(restaurantRequest.getAddress())
                .cuisine(restaurantRequest.getCuisine())
                .open_time(restaurantRequest.getOpen_time())
                .close_time(restaurantRequest.getClose_time())
                .no_of_tables(restaurantRequest.getNo_of_tables())
                .build();

        restaurantRepo.save(restaurantDetails);

        return "resto saved";
    }

    public String updaterestoservice(RestoUpdateRequest restoUpdateRequest) {
        RestaurantDetails restaurantDetails=restaurantRepo.findByName(restoUpdateRequest.getName());

        restaurantDetails.setOpen_time(restoUpdateRequest.getOpen_time());
        restaurantDetails.setClose_time(restoUpdateRequest.getClose_time());
        restaurantDetails.setNo_of_tables(restoUpdateRequest.getNo_of_tables());

        restaurantRepo.save(restaurantDetails);
        return "resto updated";

    }

    public String deleterestoservice(String name) {
        RestaurantDetails restaurantDetails=restaurantRepo.findByName(name);
        restaurantRepo.delete(restaurantDetails);
        return "Resto deleted";

    }
}
