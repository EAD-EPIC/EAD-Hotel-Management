package com.epic.demo.Booking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking saveGuest(Booking booking) {
        return bookingRepository.save(booking);
    }

    public List<Booking> getGuest() {
        return bookingRepository.findAll();
    }

    public String deleteCustomer(Long guestId) {
        bookingRepository.deleteById(guestId);
        return "customer removed";
    }

    public Booking updateGuest(Booking booking) {
        Booking existingBooking = bookingRepository.findById(booking.getGuestId()).orElse(null);
        assert existingBooking != null;
        existingBooking.setName(booking.getName());
        existingBooking.setAdults(booking.getAdults());
        existingBooking.setKids(booking.getKids());
        existingBooking.setCheckIn(booking.getCheckIn());
        existingBooking.setCheckOut(booking.getCheckOut());
        existingBooking.setRoomType(booking.getRoomType());

       return bookingRepository.save(existingBooking);
    }
}

