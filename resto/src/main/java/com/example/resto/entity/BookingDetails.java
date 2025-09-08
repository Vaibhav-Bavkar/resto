package com.example.resto.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="booking_details")
public class BookingDetails {
    @Id
    @SequenceGenerator(name = "booking_id_seq", sequenceName = "booking_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_id_seq")
    @Column(name="booking_id")
    private int bookingId;

    @ManyToOne
    @JoinColumn(name="booking_rest_fk", referencedColumnName = "rest_id")
    private RestaurantDetails restId;

    @ManyToOne
    @JoinColumn(name="booking_user_fk", referencedColumnName ="user_id")
    private UserDetails userId;

    @Column(name="date")
    private LocalDate Date;

    @Column(name = "people")
    private int people;
}
