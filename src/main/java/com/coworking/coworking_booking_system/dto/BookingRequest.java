package com.coworking.coworking_booking_system.dto;

import com.coworking.coworking_booking_system.entity.User;
import lombok.Data;
import java.time.LocalDate;

@Data
public class BookingRequest {
    private Integer workspaceId;
    private LocalDate date;
    private Integer userId;
}

