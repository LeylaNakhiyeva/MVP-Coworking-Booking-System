package com.coworking.coworking_booking_system.Repository;

import com.coworking.coworking_booking_system.Entity.Booking;
import com.coworking.coworking_booking_system.Entity.User;
import com.coworking.coworking_booking_system.Entity.Workspace;
import com.coworking.coworking_booking_system.Enum.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findByUser(User user);  //Verilən User-ə aid bütün booking-ləri List kimi qaytarır
    boolean existsByWorkspaceAndDateAndStatus(Workspace workspace, LocalDate date, BookingStatus status); // verilere uygun bookingleri yoxlayir
}
