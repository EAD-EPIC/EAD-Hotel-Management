package com.epic.demo.Booking;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
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

@Transactional
    public void updateBooking(Long guestId, String name, Integer adults, Integer kids, String roomType, Date checkIn , Date checkOut ) {
    Booking existingBooking = bookingRepository.findById(guestId)
            .orElseThrow(()-> new IllegalStateException(
            "Booking with ID" + guestId + "does not exist"));
        existingBooking.setName(name);
        existingBooking.setAdults(adults);
        existingBooking.setKids(kids);
        existingBooking.setCheckIn(checkIn);
        existingBooking.setCheckOut(checkOut);
        existingBooking.setRoomType(roomType);
}

}

