package com.example.simplehotel.dao;

import com.example.simplehotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelsRepository extends JpaRepository<Hotel,Long> {
}
