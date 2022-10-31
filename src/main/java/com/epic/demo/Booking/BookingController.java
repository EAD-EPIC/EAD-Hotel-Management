package com.epic.demo.Booking;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "booking")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public Booking addGuest (@RequestBody Booking booking){

        return bookingService.saveGuest(booking);
    }
    @GetMapping
    public List<Booking> findAllGust(){
        return bookingService.getGuest();
    }

//    @PutMapping
//    public Booking updateGuest(@RequestBody Booking booking) {
//        return bookingService.updateGuest(booking);
//
//    }


    @PutMapping(path = "{guestId}")
    public void updateBooking(
            @PathVariable("guestId") long guestId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer adults,
            @RequestParam(required = false) Integer kids,
            @RequestParam(required = false) String roomType,
            @RequestParam(required = false) Date checkIn,
            @RequestParam(required = false) Date checkOut
            ){
        bookingService.updateBooking(guestId,name,adults,kids,roomType,checkOut,checkIn);
    }

    @DeleteMapping("/{guestId}")
    public String deleteCustomer(@PathVariable Long guestId){
        return bookingService.deleteCustomer(guestId);
    }
}
