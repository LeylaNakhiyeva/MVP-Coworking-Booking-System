package com.coworking.coworking_booking_system.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private User user;
    private Workspace workspace;
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    private Status status; // CONFIRMED, CANCELLED
}