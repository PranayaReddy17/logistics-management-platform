package com.pranayareddy.backend.service.impl;

import com.pranayareddy.backend.dto.response.VersionResponse;
import com.pranayareddy.backend.service.VersionService;
import org.springframework.core.SpringVersion;
import org.springframework.stereotype.Service;

@Service
public class VersionServiceImpl implements VersionService {

    @Override
    public VersionResponse getVersion() {

        return VersionResponse.builder()
                .application("Logistics Management Platform")
                .version("1.0.0")
                .javaVersion(System.getProperty("java.version"))
                .springBootVersion(SpringVersion.getVersion())
                .build();
    }
}