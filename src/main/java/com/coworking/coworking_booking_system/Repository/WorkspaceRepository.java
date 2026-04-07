package com.coworking.coworking_booking_system.Repository;

import com.coworking.coworking_booking_system.Entity.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface WorkspaceRepository extends JpaRepository<Workspace, Integer> {

    @Query("SELECT w FROM Workspace w WHERE w.id NOT IN " +
            "(SELECT b.workspace.id FROM Booking b WHERE b.date = :date AND b.status = 'CONFIRMED')") //JPQL java obyektleri ucun yazilir
    List<Workspace> findAvailableWorkspaces(@Param("date") LocalDate date); //hemin tarixde rezerv olunmamis workspace-leri qaytarir
}

