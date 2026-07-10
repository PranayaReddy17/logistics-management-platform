package com.pranayareddy.backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VersionResponse {

    private String application;
    private String version;
    private String javaVersion;
    private String springBootVersion;
}