package com.pranayareddy.backend.dto.request;

import com.pranayareddy.backend.entity.ShipmentStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTrackingEventRequest {

    @NotNull
    private ShipmentStatus status;

    @NotBlank
    private String location;

    @NotBlank
    private String description;

    // Generate getters/setters
}