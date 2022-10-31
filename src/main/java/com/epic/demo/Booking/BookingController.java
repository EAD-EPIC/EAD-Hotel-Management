package com.epic.demo.Booking;

import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    public Booking updateGuest(@RequestBody Booking booking) {
        return bookingService.updateGuest(booking);

    }

    @DeleteMapping("/{guestId}")
    public String deleteCustomer(@PathVariable Long guestId){
        return bookingService.deleteCustomer(guestId);
    }
}
