package com.example.resto.service;

import com.example.resto.repository.BookingRepo;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    private BookingRepo bookingrepo;

    BookingService(BookingRepo bookingrepo){
        this.bookingrepo = bookingrepo;
    }
}
