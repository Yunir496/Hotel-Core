package com.example.simplehotel.controller;


import com.example.simplehotel.entity.Booking;
import com.example.simplehotel.service.BookingService;
import com.example.simplehotel.util.BookingStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/bookings")
@RestController
public class BookingController {
    @Autowired
    public BookingService bookingService;
    @GetMapping("/admin/{status}")
    public List<Booking> showAllBookings(@PathVariable String status){
        return bookingService.getAll(status);

    }


}
