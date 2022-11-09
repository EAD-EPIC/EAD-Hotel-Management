package com.epic.demo.Booking;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

@Service
public class BookingService {
    ObjectMapper objectMapper = new ObjectMapper();

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
    public void updateBooking(Long guestId, String name, Integer adults, Integer kids, String roomType, String checkIn , String checkOut) throws ParseException {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    Date check_in = formatter.parse(checkIn);
    Date check_out = formatter.parse(checkOut);

    Booking existingBooking = bookingRepository.findById(guestId)
            .orElseThrow(() -> new IllegalStateException(
                    "Booking with ID" + guestId + "does not exist"));

    if (name != null &&
            name.length()>0 &&
            !Objects.equals(existingBooking.getName(),name)){
        existingBooking.setName(name);
    }

    if (adults != null &&
            !Objects.equals(existingBooking.getAdults(),adults)){
        existingBooking.setAdults(adults);
    }

    if (kids != null &&
            !Objects.equals(existingBooking.getKids(),kids)){
        existingBooking.setKids(kids);
    }

    if (check_in != null &&
            !Objects.equals(existingBooking.getCheckIn(),check_in)){
        existingBooking.setCheckIn(check_in);
    }

    if (check_out != null &&
            !Objects.equals(existingBooking.getCheckOut(),check_out)){
        existingBooking.setCheckOut(check_out);
    }

    if (roomType != null &&
            roomType.length()>0 &&
            !Objects.equals(existingBooking.getRoomType(),roomType)){
        existingBooking.setRoomType(roomType);
    }

//    existingBooking.setName(name);
//    existingBooking.setAdults(adults);
//    existingBooking.setKids(kids);
//    existingBooking.setCheckIn(check_in);
//    existingBooking.setCheckOut(check_out);
//    existingBooking.setRoomType(roomType);

}

}


