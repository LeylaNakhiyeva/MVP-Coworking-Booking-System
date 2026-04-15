package com.coworking.coworking_booking_system.repository;

import com.coworking.coworking_booking_system.entity.Workspace;
import com.coworking.coworking_booking_system.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface WorkspaceRepository extends JpaRepository<Workspace, Integer> {

    @Query("""
        SELECT w FROM Workspace w
        WHERE NOT EXISTS (
            SELECT 1 FROM Booking b
            WHERE b.workspace = w
            AND b.date = :date
            AND b.status = :status
        )
    """)
    List<Workspace> findAvailableWorkspaces(
            @Param("date") LocalDate date,
            @Param("status") BookingStatus status
    );
}
