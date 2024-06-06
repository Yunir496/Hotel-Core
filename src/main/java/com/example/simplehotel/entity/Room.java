package com.example.simplehotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Where(clause = "delete_date is null and is_enabled = true")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="rooms")
@Entity
public class Room extends BaseEntity{

    @Column(name="person_count")
    private Integer personCount;
    private Double price;
    @Column(name="is_enabled")
    private Boolean isEnabled;
    private Integer floor;
    @Column(name="hotel_id")
    private Long hotelId;
}
