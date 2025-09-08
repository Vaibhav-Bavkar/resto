package com.example.resto.model;

import lombok.Data;

@Data
public class RestaurantRequest {

    private String name;
    private String address;
    private String cuisine;
    private String openTime;
    private String closeTime;
    private int noOfTables;

}
