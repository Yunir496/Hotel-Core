package com.example.simplehotel.dto;

import com.example.simplehotel.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BookingDto {
    private Long userId;
    private Long hotelId;
    private Long roomId;
    private LocalDate startDate;
    private LocalDate endDate;
    @Deprecated
    public static BookingDto createBookingDto(Booking booking){
        return BookingDto.builder()
                .userId(booking.getUserId())
                .hotelId(booking.getHotel().getId())
                .roomId(booking.getRoom().getId())
                .startDate(booking.getStartDate())
                .endDate(booking.getEndDate())
                .build();

    }
}
