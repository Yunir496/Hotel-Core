package com.example.simplehotel.service;

import com.example.simplehotel.dao.RoomRepository;
import com.example.simplehotel.entity.Room;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService{
    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    @Transactional
    @Override
    public List<Room> findAll(){
       return roomRepository.findAll();
    }
    @Transactional
    @Override
    public List<Room> findAllWithDeleted() {

        return roomRepository.getAll();
    }
    @Transactional
    @Override
    public Room findById(Long id) {
        if(roomRepository.findById(id).isEmpty()){
            throw new EntityNotFoundException("С таким id "+id+" комнаты не существует.");
        }
        return roomRepository.findById(id).get();
    }
    @Transactional
    @Override
    public List<Room> findAllByHotelId(Long hotelId) {
        return roomRepository.findAllByHotelId(hotelId);
    }
    @Transactional
    @Override
    public Room saveOrUpdate(Room room) {
        return roomRepository.save(room);
    }
    @Transactional
    @Override
    public void delete(Long id) {
     roomRepository.deleteRoomById(id);
    }
}
