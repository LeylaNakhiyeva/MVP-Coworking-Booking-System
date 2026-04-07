package com.coworking.coworking_booking_system.Entity;

import jakarta.persistence.*;
import lombok.*;
import com.coworking.coworking_booking_system.Enum.UserRole;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role; // USER, ADMIN
}
