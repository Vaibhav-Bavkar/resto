package com.example.resto.service;

import com.example.resto.entity.RestaurantDetails;
import com.example.resto.model.RestaurantRequest;
import com.example.resto.model.RestoUpdateRequest;
import com.example.resto.repository.RestaurantRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RestaurantService {

    private RestaurantRepo restaurantRepo;

    RestaurantService(RestaurantRepo restaurantRepo){
        this.restaurantRepo = restaurantRepo;
    }

    public List<RestaurantDetails> getRestoService() {
        log.info("Fetching all Restaurant");
        return restaurantRepo.findAll();
    }

    public RestaurantDetails getRestoByIdService(int id) {
        log.info("Fetching Restuarant by ID {}",id);
        return restaurantRepo.findById(id).get();
    }

    public String createRestoService(RestaurantRequest restaurantRequest) {
        log.info("Creating restuarant with with request {}",restaurantRequest);

        if (restaurantRepo.findByName(restaurantRequest.getName()) != null) {
            throw new RuntimeException("Restaurant already exists with name: " + restaurantRequest.getName());
        }

        RestaurantDetails restaurantDetails=RestaurantDetails.builder()
                .name(restaurantRequest.getName())
                .address(restaurantRequest.getAddress())
                .cuisine(restaurantRequest.getCuisine())
                .openTime(restaurantRequest.getOpenTime())
                .closeTime(restaurantRequest.getCloseTime())
                .noOfTables(restaurantRequest.getNoOfTables())
                .build();

        restaurantRepo.save(restaurantDetails);

        return "resto saved with rest Id:"+restaurantDetails.getRestId();
    }

    public String updateRestoService(RestoUpdateRequest restoUpdateRequest) {
        log.warn("Restaurant Updated {}",restoUpdateRequest);
        RestaurantDetails restaurantDetails=restaurantRepo.findByName(restoUpdateRequest.getName());

        restaurantDetails.setOpenTime(restoUpdateRequest.getOpen_time());
        restaurantDetails.setCloseTime(restoUpdateRequest.getClose_time());
        restaurantDetails.setNoOfTables(restoUpdateRequest.getNo_of_tables());

        restaurantRepo.save(restaurantDetails);
        return "resto updated";

    }

    public String deleteRestoService(String name) {
        log.error("Deleting Restaurant {}",name);
        RestaurantDetails restaurantDetails=restaurantRepo.findByName(name);
        restaurantRepo.delete(restaurantDetails);
        return "Resto deleted";

    }
}
