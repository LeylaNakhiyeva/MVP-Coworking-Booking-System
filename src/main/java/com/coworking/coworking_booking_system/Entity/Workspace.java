package com.coworking.coworking_booking_system.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="workspaces")
@Data
@NoArgsConstructor
@AllArgsConstructor
 public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String workspaceName;
    private String description;
    private String password;
    private String type;
    private float pricePerDay;

}