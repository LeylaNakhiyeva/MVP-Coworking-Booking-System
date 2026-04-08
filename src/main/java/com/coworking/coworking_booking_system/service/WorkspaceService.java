package com.coworking.coworking_booking_system.service;

import com.coworking.coworking_booking_system.entity.Workspace;
import com.coworking.coworking_booking_system.enums.BookingStatus;
import com.coworking.coworking_booking_system.repository.WorkspaceRepository;
import com.coworking.coworking_booking_system.repository.BookingRepository;
import com.coworking.coworking_booking_system.dto.WorkspaceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkspaceService {

    private final WorkspaceRepository workspaceRepo;
    private final BookingRepository bookingRepo;

    // 1. Bütün workspacelər
    public List<WorkspaceResponse> getAllWorkspaces() {
        return workspaceRepo.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // 2. Müəyyən tarix üçün boş workspacelər
    public List<WorkspaceResponse> getAvailableWorkspaces(LocalDate date) {

        List<Workspace> allWorkspaces = workspaceRepo.findAll();

        return allWorkspaces.stream()
                .filter(workspace ->
                        !bookingRepo.existsByWorkspaceAndDateAndStatus(
                                workspace,
                                date,
                                BookingStatus.CONFIRMED // yalnız aktiv bookingləri yoxla
                        )
                )
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // DTO mapping
    private WorkspaceResponse mapToResponse(Workspace workspace) {
        WorkspaceResponse dto = new WorkspaceResponse();
        dto.setId(workspace.getId());
        dto.setName(workspace.getWorkspaceName());
        return dto;
    }
}

