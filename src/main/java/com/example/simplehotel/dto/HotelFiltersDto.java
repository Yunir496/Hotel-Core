package com.example.simplehotel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class HotelFiltersDto {
    private String name;
    private String address;
    private Integer stars;
    private Integer personCount;
    private Double price;
    private Integer[] floors;
}
