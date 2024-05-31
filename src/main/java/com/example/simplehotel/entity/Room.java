package com.example.simplehotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.time.LocalDate;
@Where(clause = "delete_date is null and is_enabled = true")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="rooms")
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="person_count")
    private Integer personCount;
    private Double price;
    @Column(name="is_enabled")
    private Boolean isEnabled;
    @Column(name="delete_date")
    private LocalDate deleteDate;
    private Integer floor;
    @Column(name="hotel_id")
    private Long hotelId;
}
