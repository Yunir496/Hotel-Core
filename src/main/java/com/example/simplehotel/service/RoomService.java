package com.example.simplehotel.service;

import com.example.simplehotel.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();
    List<Room> findAllWithDeleted();
    Room findById(Long id);
    List<Room> findAllByHotelId(Long hotelId);
    Room saveOrUpdate(Room room);
    void delete(Long id);

}
