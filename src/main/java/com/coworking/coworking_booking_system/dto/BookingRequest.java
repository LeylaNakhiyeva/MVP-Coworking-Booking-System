package com.coworking.coworking_booking_system.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookingRequest {

    @NotNull
    private Integer workspaceId;

    @NotNull
    private LocalDate date;
}
