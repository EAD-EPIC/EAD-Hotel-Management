package com.epic.demo.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//    public Booking updateGuest(Booking booking) {
//        Booking existingBooking = bookingRepository.findById(booking.getGuestId()).orElse(null);
//        assert existingBooking != null;
//        existingBooking.setName(booking.getName());
//        existingBooking.setAdults(booking.getAdults());
//        existingBooking.setKids(booking.getKids());
//        existingBooking.setCheckIn(booking.getCheckIn());
//        existingBooking.setCheckOut(booking.getCheckOut());
//        existingBooking.setRoomType(booking.getRoomType());
//
//       return bookingRepository.save(existingBooking);
//    }

    public void updateGuest(Long guestId, String name, Integer adults, Integer kids, String roomType, Date checkIn , Date checkOut ) {
        Booking existingBooking = bookingRepository.findById(guestId)
                .orElseThrow(()-> new IllegalStateException(
                        "Booking with ID" + guestId + "does not exist"));
        existingBooking.setName(existingBooking.getName());
        existingBooking.setAdults(existingBooking.getAdults());
        existingBooking.setKids(existingBooking.getKids());
        existingBooking.setCheckIn(existingBooking.getCheckIn());
        existingBooking.setCheckOut(existingBooking.getCheckOut());
        existingBooking.setRoomType(existingBooking.getRoomType());
    }
}

