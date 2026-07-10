package com.pranayareddy.backend.service;

import com.pranayareddy.backend.dto.response.HealthResponse;

public interface HealthService {

    HealthResponse getHealthStatus();

}