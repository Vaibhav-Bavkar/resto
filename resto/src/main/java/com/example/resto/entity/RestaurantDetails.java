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
