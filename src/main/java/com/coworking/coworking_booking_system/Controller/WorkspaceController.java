package com.coworking.coworking_booking_system.Controller;

import com.coworking.coworking_booking_system.Entity.Workspace;
import com.coworking.coworking_booking_system.Repository.WorkspaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/workspaces")
@RequiredArgsConstructor
public class WorkspaceController {

    private final WorkspaceRepository workspaceRepo;

    @GetMapping
    public List<Workspace> getAll() {
        return workspaceRepo.findAll();
    }

    @GetMapping("/available")
    public List<Workspace> getAvailable(@RequestParam String date) {
        return workspaceRepo.findAvailableWorkspaces(LocalDate.parse(date));
    }
}

