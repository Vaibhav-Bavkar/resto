package com.example.resto.controller;

import com.example.resto.entity.RestaurantDetails;
import com.example.resto.model.RestaurantRequest;
import com.example.resto.model.RestoUpdateRequest;
import com.example.resto.service.RestaurantService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/resto")
@RestController
@CrossOrigin("*")
public class RestaurantController {

    private RestaurantService restaurantService;

    RestaurantController(RestaurantService restaurantService){
        this.restaurantService=restaurantService;
    }


    @GetMapping("/get")
    public List<RestaurantDetails> getRestoDetails(){
        return restaurantService.getRestoService();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<RestaurantDetails> getRestoById(@PathVariable(name = "id") int id){
        return new ResponseEntity<>(restaurantService.getRestoByIdService(id),HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createResto(@RequestBody RestaurantRequest restaurantRequest){
        return new ResponseEntity<>(this.restaurantService.createRestoService(restaurantRequest), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateResto(@RequestBody RestoUpdateRequest restoUpdateRequest){
        return new ResponseEntity<>(this.restaurantService.updateRestoService(restoUpdateRequest),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    public ResponseEntity<String> deleteResto(@PathVariable String name){
        return new ResponseEntity<>(this.restaurantService.deleteRestoService(name),HttpStatus.OK);
    }


}
