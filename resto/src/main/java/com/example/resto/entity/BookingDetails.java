package com.example.resto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="booking_details")
public class BookingDetails {
    @Id
    @SequenceGenerator(name = "booking_id_seq", sequenceName = "booking_id_seq", allocationSize = 1, initialValue = 15)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_id_seq")
    @Column(name="booking_id")
    private int booking_id;

    @Column(name = "rest_id")
    private int rest_id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "table_id")
    private int table_id;

    @Column(name = "open_time")
    private String open_time;

    @Column(name = "close_time")
    private String close_time;

    @Column(name = "status")
    private String status;

    @Column(name = "people")
    private String people;
}
