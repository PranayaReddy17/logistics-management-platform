package com.pranayareddy.backend.controller;

import com.pranayareddy.backend.dto.response.HealthResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1")
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<HealthResponse> health() {

        HealthResponse response = HealthResponse.builder()
                .status("UP")
                .application("Logistics Management Platform")
                .version("1.0.0")
                .environment("local")
                .timestamp(Instant.now().toString())
                .build();

        return ResponseEntity.ok(response);
    }
}