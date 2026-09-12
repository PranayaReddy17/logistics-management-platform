package com.pranayareddy.backend.dto.response;

import com.pranayareddy.backend.entity.ShipmentStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ShipmentTrackingResponse {

    private ShipmentStatus status;
    private String location;
    private String description;
    private Instant eventTime;

    // Generate getters/setters
}