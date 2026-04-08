package com.coworking.coworking_booking_system.Controller;

import com.coworking.coworking_booking_system.DTO.BookingRequest;
import com.coworking.coworking_booking_system.Entity.Booking;
import com.coworking.coworking_booking_system.Service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

//import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    // 1. Booking yarat
    @PostMapping
    public Booking createBooking(@Valid @RequestBody BookingRequest request) {
        return bookingService.createBooking(
                request.getUserId(),
                request.getWorkspaceId(),
                request.getDate()
        );
    }

    // 2. Öz bookinglərini gör
    @GetMapping("/my")
    public List<Booking> getMyBookings(@RequestParam Integer userId) {
        return bookingService.getMyBookings(userId);
    }

    // 3. Booking sil
    @DeleteMapping("/{id}")
    public void cancelBooking(@PathVariable Long id,
                              @RequestParam Long userId) {
        bookingService.cancelBooking(id, userId);
    }
}
