package com.pranayareddy.backend.controller;

import com.pranayareddy.backend.dto.response.VersionResponse;
import com.pranayareddy.backend.service.VersionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.Instant;
import com.pranayareddy.backend.dto.response.ApiResponse;

@RestController
@RequestMapping("/api/v1")
public class VersionController {

    private final VersionService versionService;

    public VersionController(VersionService versionService) {
        this.versionService = versionService;
    }

    @GetMapping("/version")
    public ResponseEntity<ApiResponse<VersionResponse>> getVersion() {

        VersionResponse version = versionService.getVersion();

        ApiResponse<VersionResponse> response = ApiResponse.<VersionResponse>builder()
                .success(true)
                .message("Version retrieved successfully")
                .data(version)
                .timestamp(Instant.now())
                .build();

        return ResponseEntity.ok(response);
    }
}