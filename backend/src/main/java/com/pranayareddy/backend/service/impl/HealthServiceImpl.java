package com.pranayareddy.backend.service.impl;

import com.pranayareddy.backend.dto.response.HealthResponse;
import com.pranayareddy.backend.service.HealthService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class HealthServiceImpl implements HealthService {

    @Override
    public HealthResponse getHealthStatus() {

        return HealthResponse.builder()
                .status("UP")
                .application("Logistics Management Platform")
                .version("1.0.0")
                .environment("local")
                .timestamp(Instant.now().toString())
                .build();
    }
}