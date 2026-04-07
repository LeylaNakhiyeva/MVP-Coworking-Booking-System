package com.coworking.coworking_booking_system.Service;

import com.coworking.coworking_booking_system.Entity.*;  // ?????????????????????????????
import com.coworking.coworking_booking_system.Enum.BookingStatus;
import com.coworking.coworking_booking_system.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor   // final saheler ucun avtomatik constructor yaradir
public class BookingService {

    private final BookingRepository bookingRepo;     // service repository-lerden asilidir
    private final WorkspaceRepository workspaceRepo;  //DB əməliyyatlarını repository-lər vasitəsilə edir
    private final UserRepository userRepo;

    @Transactional   // bütün əməliyyat bir transaction-da olur
    public Booking createBooking(Integer userId, Integer workspaceId, LocalDate date) {
        if (date.isBefore(LocalDate.now())) {
            throw new RuntimeException("Date cannot be in the past");
        }

        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Workspace workspace = workspaceRepo.findById(workspaceId).orElseThrow(() -> new RuntimeException("Workspace not found"));

        if (bookingRepo.existsByWorkspaceAndDateAndStatus(workspace, date, BookingStatus.CONFIRMED)) {
            throw new RuntimeException("Workspace already booked for this date");
        }

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setWorkspace(workspace);
        booking.setDate(date);
        booking.setStatus(BookingStatus.CONFIRMED);

        return bookingRepo.save(booking);
    }

    public List<Booking> getMyBookings(Integer userId) {
        User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return bookingRepo.findByUser(user);
    }
}
