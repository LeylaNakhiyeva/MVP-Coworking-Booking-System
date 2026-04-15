package com.coworking.coworking_booking_system.service;

import com.coworking.coworking_booking_system.entity.Booking;
import com.coworking.coworking_booking_system.entity.User;
import com.coworking.coworking_booking_system.entity.Workspace;
import com.coworking.coworking_booking_system.enums.BookingStatus;
import com.coworking.coworking_booking_system.exception.NotFoundException;
import com.coworking.coworking_booking_system.exception.ConflictException;
import com.coworking.coworking_booking_system.exception.AccessDeniedException;
import com.coworking.coworking_booking_system.repository.BookingRepository;
import com.coworking.coworking_booking_system.repository.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final WorkspaceRepository workspaceRepository;

    public Booking createBooking(Integer workspaceId, LocalDate date, User user) {

        Workspace workspace = workspaceRepository.findById(workspaceId)
                .orElseThrow(() -> new NotFoundException("Workspace not found"));

        boolean exists = bookingRepository.existsByWorkspaceAndDateAndStatus(
                workspace,
                date,
                BookingStatus.CONFIRMED
        );

        if (exists) {
            throw new ConflictException("Workspace already booked for this date");
        }

        Booking booking = new Booking();
        booking.setWorkspace(workspace);
        booking.setUser(user);
        booking.setDate(date);
        booking.setStatus(BookingStatus.CONFIRMED);

        return bookingRepository.save(booking);
    }

    public List<Booking> getMyBookings(User user) {
        return bookingRepository.findByUser(user);
    }

    public void cancelBooking(Integer id, User user) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Booking not found"));

        if (!booking.getUser().getId().equals(user.getId())) {
            throw new AccessDeniedException("You cannot cancel this booking");
        }

        booking.setStatus(BookingStatus.CANCELLED);
        bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }
}
