package com.coworking.coworking_booking_system.Controller;

import com.coworking.coworking_booking_system.Entity.Booking;
import com.coworking.coworking_booking_system.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestParam Integer userId,
                                 @RequestParam Integer workspaceId,
                                 @RequestParam String date) {
        return bookingService.createBooking(userId, workspaceId, LocalDate.parse(date));
    }

    @GetMapping("/my")
    public List<Booking> getMyBookings(@RequestParam Integer userId) {
        return bookingService.getMyBookings(userId);
    }
}
