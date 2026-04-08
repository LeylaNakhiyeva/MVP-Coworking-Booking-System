package com.coworking.coworking_booking_system.DTO;

import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

public class BookingRequest {
    @NotNull
    private Long workspaceId;

    @FutureOrPresent
    private LocalDate date;
}
