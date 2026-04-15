package com.coworking.coworking_booking_system.dto;

import com.coworking.coworking_booking_system.enums.WorkspaceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class WorkspaceRequest {

    @NotBlank
    private String name;

    private String description;

    @NotNull
    private BigDecimal pricePerDay;

    @NotNull
    private WorkspaceType type;
}
