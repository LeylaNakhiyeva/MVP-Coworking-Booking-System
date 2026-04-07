package com.coworking.coworking_booking_system.Repository;

import com.coworking.coworking_booking_system.Entity.Booking;
import com.coworking.coworking_booking_system.Entity.User;
import com.coworking.coworking_booking_system.Entity.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(User user);
    boolean existsByWorkspaceAndDateAndStatus(Workspace workspace, LocalDate date, BookingStatus status);
}
