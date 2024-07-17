package com.example.simplehotel.service;

import com.example.simplehotel.dto.BookingDto;
import com.example.simplehotel.entity.Booking;

import java.util.List;

public interface BookingService  {
   Booking create(BookingDto bookingDto);
   List<Booking> getAll();
   List<Booking> getByUserId(Long id);
   List<Booking> getByRoomId(Long id);
   void delete(Long id);

}
