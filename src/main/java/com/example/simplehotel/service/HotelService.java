package com.example.simplehotel.service;

import com.example.simplehotel.dto.HotelFiltersDto;
import com.example.simplehotel.entity.Hotel;
import liquibase.pro.packaged.H;

import java.util.List;


public interface HotelService {
    Hotel getById(Long Id);
    Hotel updateOrCreate(Hotel hotel);
    void deleteHotel(Long id);
    List<Hotel> getAll();//получение всех отелей с удаленными
    List<Hotel> getAllByFilters(HotelFiltersDto hotelFiltersDto);


}
