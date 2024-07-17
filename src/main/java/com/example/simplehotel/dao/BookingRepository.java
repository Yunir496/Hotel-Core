package com.example.simplehotel.dao;

import com.example.simplehotel.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
     List<Booking> findBookingByUserId(Long userId);
     List<Booking> findBookingByRoomId(Long roomId);
     @Modifying
     @Query("update Booking b set b.deleteDate = sysdate() where b.id = :id")
     void deleteBooking(@Param("id") Long id);
     @Query(value = "call validate_booking_date(:room_id,:start_date,:end_date)",nativeQuery = true)
     int validate (@Param("room_id") Long roomId, @Param("start_date") LocalDate startDate, @Param("end_date") LocalDate endDate);



}
