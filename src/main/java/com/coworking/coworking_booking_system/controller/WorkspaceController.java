package com.coworking.coworking_booking_system.controller;

import com.coworking.coworking_booking_system.dto.WorkspaceResponse;
import com.coworking.coworking_booking_system.service.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/workspaces")
@RequiredArgsConstructor
public class WorkspaceController {

    private final WorkspaceService workspaceService;

    // 1. Bütün workspacelər
    @GetMapping
    public List<WorkspaceResponse> getAllWorkspaces() {
        return workspaceService.getAllWorkspaces();
    }

    // 2. Müəyyən tarix üçün boş workspacelər
    @GetMapping("/available")
    public List<WorkspaceResponse> getAvailableWorkspaces(@RequestParam LocalDate date) {
        return workspaceService.getAvailableWorkspaces(date);
    }
}


