package com.example.simplehotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;


import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="hotels")
@Entity
@Where(clause="delete_date is null")
public class Hotel extends BaseEntity {

    @Column(name="comfort_level")
    private Integer stars;
    private String address;
    private String name;
    @OneToMany(mappedBy="hotelId")
    private List<Room> rooms;

}
