package com.example.simplehotel.service;

import com.example.simplehotel.dao.HotelRepository;
import com.example.simplehotel.dto.HotelFiltersDto;
import com.example.simplehotel.entity.Hotel;
import com.example.simplehotel.util.HotelSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class HotelServiceImpl implements HotelService{
    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    @Transactional
    public Hotel updateOrCreate(Hotel hotel) {
        return hotelRepository.save(hotel);
    }
    @Transactional
    @Override
    public void deleteHotel(Long id) {

        hotelRepository.deleteHotelById(id);

    }

    @Transactional
    @Override
    public List<Hotel> getAll() {
        return hotelRepository.getAll();
    }
    @Transactional
    @Override
    public List<Hotel> getAllByFilters(HotelFiltersDto hotelFilters) {

        Specification<Hotel> specification = HotelSpecifications.hotelFilter(hotelFilters);
        return hotelRepository.findAll(specification);
    }
}
