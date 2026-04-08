package com.coworking.coworking_booking_system.service;

import com.coworking.coworking_booking_system.entity.Booking;
import com.coworking.coworking_booking_system.entity.User;
import com.coworking.coworking_booking_system.entity.Workspace;
import com.coworking.coworking_booking_system.enums.BookingStatus;
import com.coworking.coworking_booking_system.repository.BookingRepository;
import com.coworking.coworking_booking_system.repository.WorkspaceRepository;
import com.coworking.coworking_booking_system.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepo;
    private final WorkspaceRepository workspaceRepo;
    private final UserRepository userRepo;

    // ✅ Booking yaratmaq
    public Booking createBooking(Integer workspaceId, Integer userId, LocalDate date) {

        // 1. Workspace tap
        Workspace workspace = workspaceRepo.findById(workspaceId)
                .orElseThrow(() -> new RuntimeException("Workspace tapılmadı"));

        // 2. User tap
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User tapılmadı"));

        // 3. Conflict yoxla (yalnız CONFIRMED-lərə görə)
        boolean exists = bookingRepo.existsByWorkspaceAndDateAndStatus(
                workspace,
                date,
                BookingStatus.CONFIRMED
        );

        if (exists) {
            throw new RuntimeException("Bu workspace artıq bron olunub!");
        }

        // 4. Booking yarat
        Booking booking = new Booking();
        booking.setWorkspace(workspace);
        booking.setUser(user);
        booking.setDate(date);
        booking.setStatus(BookingStatus.CONFIRMED); // default status

        return bookingRepo.save(booking);
    }

    // ✅ User-ə aid bookinglər
    public List<Booking> getBookingsByUser(Integer userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User tapılmadı"));

        return bookingRepo.findByUser(user);
    }
}
