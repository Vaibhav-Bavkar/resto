package com.example.resto.model;

import com.example.resto.entity.RestaurantDetails;
import com.example.resto.entity.UserDetails;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@Data
public class BookingRequest {
    private int restId;
    private int userId;
    private LocalDate date;
    private int people;

}
