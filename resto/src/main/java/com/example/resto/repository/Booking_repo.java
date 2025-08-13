package com.example.resto.repository;

import com.example.resto.entity.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Booking_repo extends JpaRepository<BookingDetails,Integer> {
}
