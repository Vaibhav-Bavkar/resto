package com.example.resto.model;

import lombok.Data;

@Data
public class RestaurantRequest {

    private String name;
    private String address;
    private String cuisine;
    private String open_time;
    private String close_time;
    private int no_of_tables;

}
