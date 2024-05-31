package com.example.simplehotel.dao;

import com.example.simplehotel.entity.Hotel;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long>, JpaSpecificationExecutor<Hotel> {
    //Метод получения всех отелей с удаленными
    @Query(value = "select * from hotels", nativeQuery = true)
    List<Hotel> getAll();

    @Modifying
    @Query("update Hotel h set h.deleteDate = sysdate() where h.id = :id")
    void deleteHotelById(@Param("id") Long id);

    List<Hotel> findAll(Specification<Hotel> spec);

}
