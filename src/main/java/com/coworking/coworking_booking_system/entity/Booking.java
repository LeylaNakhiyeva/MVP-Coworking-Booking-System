package com.coworking.coworking_booking_system.entity;

import java.time.LocalDate;
import com.coworking.coworking_booking_system.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private User user;
    private Workspace workspace;
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private BookingStatus status; // CONFIRMED, CANCELLED
}