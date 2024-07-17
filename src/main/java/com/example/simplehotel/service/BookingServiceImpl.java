package com.example.simplehotel.service;

import com.example.simplehotel.dao.BookingRepository;
import com.example.simplehotel.dto.BookingDto;
import com.example.simplehotel.entity.Booking;
import com.example.simplehotel.entity.Hotel;
import com.example.simplehotel.entity.Room;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.temporal.ChronoUnit;
import java.util.List;


@Service
public class BookingServiceImpl implements BookingService {
    private final HotelService hotelService;
    private final RoomService roomService;
    private final BookingRepository bookingRepository;

    public BookingServiceImpl(HotelService hotelService, RoomService roomService, BookingRepository bookingRepository) {
        this.hotelService = hotelService;
        this.roomService = roomService;
        this.bookingRepository = bookingRepository;
    }

    @Transactional
    @Override
    public Booking create(BookingDto bookingDto) {
        Hotel hotel = hotelService.getById(bookingDto.getHotelId());
        Room room = roomService.findById(bookingDto.getRoomId());
        if (!hotel.getId().equals(room.getHotelId())) {
            throw new RuntimeException("Комнаты с Id " + room.getId() + " нет в этом отеле с Id " + hotel.getId());
        }
        if (!room.getIsEnabled()) {
            throw new RuntimeException("Комнаты с Id " + room.getId() + " недоступна");
        }
        //List<Booking> bookings = getByRoomId(room.getId());
        int isNotValid = bookingRepository.validate(bookingDto.getRoomId(), bookingDto.getStartDate(),bookingDto.getEndDate());
//        Optional<Booking> roomIsBooked = bookings.stream().filter(b -> (bookingDto.getStartDate().isAfter(b.getStartDate())
//                && bookingDto.getStartDate().isBefore(b.getEndDate())
//                || (bookingDto.getEndDate().isAfter(b.getStartDate())
//                && bookingDto.getEndDate().isBefore(b.getEndDate()))
//                || (b.getStartDate().isAfter(bookingDto.getStartDate())
//                && b.getStartDate().isBefore(bookingDto.getEndDate())))
//                || (b.getEndDate().isAfter(bookingDto.getStartDate()) && b.getEndDate().isBefore(bookingDto.getEndDate()))
//                || (b.getStartDate().isEqual(bookingDto.getStartDate()) || b.getStartDate().isEqual(bookingDto.getEndDate()))
//                || (b.getEndDate().isEqual(bookingDto.getStartDate()) || b.getEndDate().isEqual(bookingDto.getEndDate()))).findFirst();
        if (isNotValid == 1) {
            throw new RuntimeException("Некорректные даты брони");
        }
        if (bookingDto.getStartDate().isAfter(bookingDto.getEndDate())) {
            throw new RuntimeException("Дата начала бронирования позже даты окончания");
        }
        Long period = bookingDto.getStartDate().until(bookingDto.getEndDate(), ChronoUnit.DAYS);
        Booking booking = new Booking(bookingDto.getUserId(), hotel, room, bookingDto.getStartDate(), bookingDto.getEndDate(),
                period * room.getPrice());
        return bookingRepository.save(booking);
    }

    @Transactional
    @Override
    public List<Booking> getAll() {
        return bookingRepository.findAll();
    }

    @Transactional
    @Override
    public List<Booking> getByUserId(Long id) {
        return bookingRepository.findBookingByUserId(id);
    }

    @Transactional
    @Override
    public List<Booking> getByRoomId(Long id) {
        return bookingRepository.findBookingByRoomId(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        bookingRepository.deleteBooking(id);
    }
}
