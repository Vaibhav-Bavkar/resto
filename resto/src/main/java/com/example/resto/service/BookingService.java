package com.example.resto.service;

import com.example.resto.entity.BookingDetails;
import com.example.resto.entity.RestaurantDetails;
import com.example.resto.entity.UserDetails;
import com.example.resto.model.BookingRequest;
import com.example.resto.repository.BookingRepo;
import com.example.resto.repository.RestaurantRepo;
import com.example.resto.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class BookingService {

    private BookingRepo bookingrepo;
    private UserRepo userRepo;
    private RestaurantRepo restaurantRepo;

    BookingService(BookingRepo bookingrepo,UserRepo userRepo,RestaurantRepo restaurantRepo){
        this.bookingrepo = bookingrepo;
        this.userRepo = userRepo;
        this.restaurantRepo = restaurantRepo;
    }

    public List<BookingDetails> getAllBookingService() {
        log.info("Fetching all Bookings");
        return bookingrepo.findAll();

    }

    public BookingDetails getBookingByIdService(int id) {
        log.info("Fetching all Bookings by ID {}",id);
        return bookingrepo.findById(id).get();
    }

    public String createBookingService(BookingRequest bookingRequest) {
        log.info("Booking Created {}",bookingRequest);

        UserDetails userDetails=userRepo.findById(bookingRequest.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + bookingRequest.getUserId()));
        RestaurantDetails restaurantDetails = restaurantRepo.findById(bookingRequest.getRestId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + bookingRequest.getRestId()));


        BookingDetails bookingDetails=BookingDetails.builder()
                .Date(bookingRequest.getDate())
                .people(bookingRequest.getPeople())
                .userId(userDetails)
                .restId(restaurantDetails)
                .build();
        bookingrepo.save(bookingDetails);
        return "Booking Created with Booking Id:"+bookingDetails.getBookingId();
    }


    public String deleteBookingService(int id) {
        log.error("Booking Deleting {}",id);
        BookingDetails bookingDetails=bookingrepo.findById(id).get();
        bookingrepo.delete(bookingDetails);
        return "Booking Deleted";
    }
}
