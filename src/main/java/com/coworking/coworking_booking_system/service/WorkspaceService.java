package com.coworking.coworking_booking_system.service;

import com.coworking.coworking_booking_system.dto.WorkspaceResponse;
import com.coworking.coworking_booking_system.entity.Workspace;
import com.coworking.coworking_booking_system.enums.BookingStatus;
import com.coworking.coworking_booking_system.repository.WorkspaceRepository;
import com.coworking.coworking_booking_system.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkspaceService {

    private final WorkspaceRepository workspaceRepository;

    public List<WorkspaceResponse> getAllWorkspaces() {
        return workspaceRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public List<WorkspaceResponse> getAvailableWorkspaces(LocalDate date) {

        return workspaceRepository
                .findAvailableWorkspaces(date, BookingStatus.CONFIRMED)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public WorkspaceResponse createWorkspace(Workspace workspace) {
        return mapToResponse(workspaceRepository.save(workspace));
    }

    public WorkspaceResponse updateWorkspace(Integer id, Workspace updated) {

        Workspace ws = workspaceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Workspace not found"));

        ws.setName(updated.getName());
        ws.setDescription(updated.getDescription());
        ws.setPricePerDay(updated.getPricePerDay());
        ws.setType(updated.getType());

        return mapToResponse(workspaceRepository.save(ws));
    }

    private WorkspaceResponse mapToResponse(Workspace workspace) {
        WorkspaceResponse dto = new WorkspaceResponse();
        dto.setId(workspace.getId());
        dto.setName(workspace.getName());
        dto.setDescription(workspace.getDescription());
        dto.setPricePerDay(workspace.getPricePerDay());
        dto.setType(workspace.getType());
        return dto;
    }
}



