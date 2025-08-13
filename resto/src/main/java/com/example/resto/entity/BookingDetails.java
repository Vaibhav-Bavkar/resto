package com.example.resto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table
public class BookingDetails {
    @Id
    private int booking_id;
    private int rest_id;
    private int user_id;
    private int table_id;
    private String open_time;
    private String close_time;
    private String status;
    private String people;
}
