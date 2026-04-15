package com.coworking.coworking_booking_system.dto;

import com.coworking.coworking_booking_system.enums.BookingStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class BookingResponse {

    private Integer id;
    private String workspaceName;
    private String username;
    private LocalDate date;
    private BookingStatus status;
}
