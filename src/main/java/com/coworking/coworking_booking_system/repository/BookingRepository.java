package com.coworking.coworking_booking_system.repository;

import com.coworking.coworking_booking_system.entity.Booking;
import com.coworking.coworking_booking_system.entity.User;
import com.coworking.coworking_booking_system.entity.Workspace;
import com.coworking.coworking_booking_system.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByUser(User user);  //Verilən User-ə aid bütün booking-ləri List kimi qaytarır
    boolean existsByWorkspaceAndDateAndStatus(Workspace workspace, LocalDate date, BookingStatus status); // verilere uygun bookingleri yoxlayir
}
