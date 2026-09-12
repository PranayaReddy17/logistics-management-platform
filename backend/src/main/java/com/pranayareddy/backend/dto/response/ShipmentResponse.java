package com.pranayareddy.backend.dto.response;

import com.pranayareddy.backend.entity.Carrier;
import com.pranayareddy.backend.entity.ShipmentStatus;

import java.math.BigDecimal;
import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShipmentResponse {

    private Long id;
    private String trackingNumber;
    private String senderName;
    private String receiverName;
    private String origin;
    private String destination;
    private BigDecimal weight;
    private Carrier carrier;
    private ShipmentStatus status;
    private Instant createdAt;
    private Instant updatedAt;

    // Generate getters and setters
}