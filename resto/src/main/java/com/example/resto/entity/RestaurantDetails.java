package com.example.resto.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="restaurant_details")
public class RestaurantDetails {
    @Id
    private int rest_id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "cuisine")
    private String cuisine;
    @Column(name ="open_time")
    private String open_time;
    @Column(name = "close_time")
    private String close_time;
    @Column(name = "no_of_tables")
    private int no_of_tables;
}
