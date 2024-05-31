package com.example.simplehotel.util;

import com.example.simplehotel.dto.HotelFiltersDto;
import com.example.simplehotel.entity.Hotel;
import com.example.simplehotel.entity.Room;
import org.apache.logging.log4j.util.Strings;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


public class HotelSpecifications {
    public static Specification<Hotel> hotelFilter(HotelFiltersDto hotelFiltersDto) {
        return ((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (Strings.isNotEmpty(hotelFiltersDto.getName())) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + hotelFiltersDto.getName() + "%"));
            }
            if (Strings.isNotEmpty(hotelFiltersDto.getAddress())) {
                predicates.add(criteriaBuilder.like(root.get("address"), "%" + hotelFiltersDto.getAddress() + "%"));
            }
            if (hotelFiltersDto.getStars() != null) {
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("stars"), hotelFiltersDto.getStars()));
            }
            if (hotelFiltersDto.getPersonCount() != null) {
                Join<Hotel, Room> roomJoin = root.join("rooms");
                predicates.add(criteriaBuilder.greaterThanOrEqualTo(roomJoin.get("personCount"), hotelFiltersDto.getPersonCount()));
            }
            if (hotelFiltersDto.getPrice() != null) {
                Join<Hotel, Room> roomJoin = root.join("rooms");
                predicates.add(criteriaBuilder.lessThanOrEqualTo(roomJoin.get("price"), hotelFiltersDto.getPrice()));
            }
            if (hotelFiltersDto.getFloors() != null) {
                Join<Hotel, Room> roomJoin = root.join("rooms");
                predicates.add(roomJoin.get("floor").in((Object[]) hotelFiltersDto.getFloors()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });

    }
}

