package com.coworking.coworking_booking_system.entity;

import jakarta.persistence.*;
import lombok.*;
import com.coworking.coworking_booking_system.enums.WorkspaceType;

@Entity
@Table(name="workspaces")
@Data
@NoArgsConstructor
@AllArgsConstructor
 public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String workspaceName;
    private String description;
    private String password;
    private float pricePerDay;

    @Enumerated(EnumType.STRING)
   private WorkspaceType type;

}