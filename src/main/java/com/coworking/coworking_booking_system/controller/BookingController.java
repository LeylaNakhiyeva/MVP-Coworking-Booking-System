package com.coworking.coworking_booking_system.controller;

import com.coworking.coworking_booking_system.dto.BookingRequest;
import com.coworking.coworking_booking_system.entity.Booking;
import com.coworking.coworking_booking_system.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    // ✅ 1. Booking yaratmaq
    @PostMapping
    public Booking createBooking(@RequestBody BookingRequest request) {
        return bookingService.createBooking(
                request.getWorkspaceId(),
                request.getUserId(),
                request.getDate()
        );
    }

    // ✅ 2. User-ə aid bütün bookinglər
    @GetMapping("/user/{userId}")
    public List<Booking> getUserBookings(@PathVariable Integer userId) {
        return bookingService.getBookingsByUser(userId);
    }
}
