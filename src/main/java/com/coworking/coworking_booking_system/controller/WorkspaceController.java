package com.coworking.coworking_booking_system.controller;

import com.coworking.coworking_booking_system.dto.WorkspaceResponse;
import com.coworking.coworking_booking_system.entity.Workspace;
import com.coworking.coworking_booking_system.service.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/workspaces")
@RequiredArgsConstructor
public class WorkspaceController {

    private final WorkspaceService workspaceService;

    // 1. Bütün workspace-lər
    @GetMapping
    public ResponseEntity<List<WorkspaceResponse>> getAll() {
        return ResponseEntity.ok(workspaceService.getAllWorkspaces());
    }

    // 2. Müəyyən tarixə görə boş workspace-lər
    @GetMapping("/available")
    public ResponseEntity<List<WorkspaceResponse>> getAvailable(
            @RequestParam LocalDate date
    ) {
        return ResponseEntity.ok(workspaceService.getAvailableWorkspaces(date));
    }

    // 3. Yeni workspace yaratmaq
    @PostMapping
    public ResponseEntity<WorkspaceResponse> create(
            @RequestBody Workspace workspace
    ) {
        return ResponseEntity.ok(workspaceService.createWorkspace(workspace));
    }

    // 4. Workspace update
    @PutMapping("/{id}")
    public ResponseEntity<WorkspaceResponse> update(
            @PathVariable Integer id,
            @RequestBody Workspace workspace
    ) {
        return ResponseEntity.ok(workspaceService.updateWorkspace(id, workspace));
    }
}
