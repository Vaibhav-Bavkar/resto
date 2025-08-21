package com.example.resto.controller;

import com.example.resto.model.RestaurantRequest;
import com.example.resto.model.RestoUpdateRequest;
import com.example.resto.service.RestaurantService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/resto")
@RestController
public class RestaurantController {

    private RestaurantService restaurantService;

    RestaurantController(RestaurantService restaurantService){
        this.restaurantService=restaurantService;
    }


    @PostMapping("/create")
    public ResponseEntity<String> createresto(@RequestBody RestaurantRequest restaurantRequest){
        return new ResponseEntity<>(this.restaurantService.createrestoservice(restaurantRequest), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateresto(@RequestBody RestoUpdateRequest restoUpdateRequest){
        return new ResponseEntity<>(this.restaurantService.updaterestoservice(restoUpdateRequest),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deletereso(@PathVariable String name){
        return new ResponseEntity<>(this.restaurantService.deleterestoservice(name),HttpStatus.OK);
    }


}
