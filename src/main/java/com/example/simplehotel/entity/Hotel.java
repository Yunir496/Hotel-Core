package com.example.simplehotel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="hotels")
@Entity
@Where(clause="delete_date is null")
public class Hotel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="comfort_level")
    private Integer stars;
    private String address;
    private String name;
    @OneToMany(mappedBy="hotelId")
    private List<Room> rooms;
    @Column(name="delete_date")
    private LocalDate deleteDate;
    //todo Вынести общие поля сущности в родительскую сущность
}
