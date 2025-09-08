package com.example.resto.controller;

import com.example.resto.entity.BookingDetails;
import com.example.resto.model.BookingRequest;
import com.example.resto.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@CrossOrigin("*")
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService){
        this.bookingService=bookingService;
    }

    @GetMapping("/get")
    public List<BookingDetails> getAllBookings(){
        return bookingService.getAllBookingService();
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<BookingDetails> getBookingById(@PathVariable(name="id") int id){
        return new ResponseEntity<>(this.bookingService.getBookingByIdService(id),HttpStatus.OK);
    }




    @PostMapping("/create")
    public ResponseEntity<String> createBooking(@RequestBody BookingRequest bookingRequest){
        return new ResponseEntity<>(this.bookingService.createBookingService(bookingRequest), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable (name="id") int id){
        return new ResponseEntity<>(this.bookingService.deleteBookingService(id),HttpStatus.OK);
    }









}
