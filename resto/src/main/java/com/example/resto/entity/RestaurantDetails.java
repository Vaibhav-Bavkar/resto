package com.example.resto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="restaurant_details")
public class RestaurantDetails {
    @Id
    @SequenceGenerator(name="rest_id_seq", sequenceName = "rest_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rest_id_seq")
    @Column(name="rest_id")
    private int restId;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "cuisine")
    private String cuisine;
    @Column(name ="open_time")
    private String openTime;
    @Column(name = "close_time")
    private String closeTime;
    @Column(name = "no_of_tables")
    private int noOfTables;


}
