package com.example.simplehotel.dao;

import com.example.simplehotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room,Long> {
    //Поиск всех комнат

    //Поиск всех и удаленных
    @Query(value = "select * from rooms", nativeQuery = true)
    List<Room> getAll();
    //Поиск всех комнат какогото конкретного отеля
    List<Room> findAllByHotelId(Long hotelId);
    //Поиск конкретной комнаты по ID

    //Добавление, обновление и удаление софтделит
    @Modifying
    @Query("update Room r set r.deleteDate = sysdate() where r.id = :id")
    void deleteRoomById(@Param("id") Long id);
}
