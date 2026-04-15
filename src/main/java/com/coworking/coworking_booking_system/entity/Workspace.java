package com.coworking.coworking_booking_system.entity;

import jakarta.persistence.*;
import lombok.*;
import com.coworking.coworking_booking_system.enums.WorkspaceType;

import java.math.BigDecimal;

@Entity
@Table(name = "workspaces")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Workspace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private BigDecimal pricePerDay;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WorkspaceType type;
}
