package com.example.simplehotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="bookings")
public class Booking extends BaseEntity{
    @Column(name = "user_id")
    private Long userId;
    @ManyToOne()
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
    @ManyToOne()
    @JoinColumn(name = "room_id")
    private Room room;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "total_price")
    private Double totalPrice;
}
