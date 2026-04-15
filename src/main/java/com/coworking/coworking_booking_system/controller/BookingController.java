package com.coworking.coworking_booking_system.controller;

import com.coworking.coworking_booking_system.dto.BookingRequest;
import com.coworking.coworking_booking_system.entity.Booking;
import com.coworking.coworking_booking_system.entity.User;
import com.coworking.coworking_booking_system.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    // CREATE
    @PostMapping
    public ResponseEntity<Booking> create(@RequestBody BookingRequest request,
                                          @AuthenticationPrincipal User user) {

        Booking booking = bookingService.createBooking(
                request.getWorkspaceId(),
                request.getDate(),
                user
        );

        return ResponseEntity.ok(booking);
    }

    // USER bookings
    @GetMapping("/my")
    public List<Booking> myBookings(@AuthenticationPrincipal User user) {
        return bookingService.getMyBookings(user);
    }

    // CANCEL
    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancel(@PathVariable Integer id,
                                    @AuthenticationPrincipal User user) {

        bookingService.cancelBooking(id, user);
        return ResponseEntity.ok("Cancelled");
    }

    // ADMIN
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Booking> getAll() {
        return bookingService.getAllBookings();
    }
}





//@RestController
//@RequestMapping("/api/bookings")
//@RequiredArgsConstructor
//public class BookingController {
//
//    private final BookingService bookingService;
//
//    //1. Booking yaratmaq
//    @PostMapping
//    public Booking createBooking(@RequestBody BookingRequest request) {
//        return bookingService.createBooking(
//                request.getWorkspaceId(),
//                request.getUserId(),
//                request.getDate()
//        );
//
//        /*
//        burda user oz userID sin gonderir.
//        bize lazimdi ki sistem ozu yoxlasin ki
//         user authentifikasiyadan kecib onun sessiyasin gotursun.
//        indi ki halda login olma yoxlanilmir.
//         */
//    }
//
//    //2. User-ə aid bütün bookinglər
//    @GetMapping("/user/{userId}") /*
//    burda usera aid butun bookingler gelecek. sadece burda da yene
//    {userID} elnen gonderilir. Example :
//    ele bil ki, men senin mobil nomrevi gonderirem  endpointe senin
//    butun whatsapp yazishmalarin
//    gorsenir, yoxlamir ki bu nomre mene aiddi ya yox.
//    */
//    public List<Booking> getUserBookings(@PathVariable Integer userId) {
//        return bookingService.getBookingsByUser(userId);
//    }
//}
//
//
///*
//hec bir kodunda gonderilen datalari yoxlamirsan. @Valid @NotNull @FutureOrPresent  @NotBlank
//date kohne tarixle gonderib bron elesem goturecek.
//workspaceId = null
//userId = null
//date = null
//bele gondersende goturecek.
//
//
// */
//
//
