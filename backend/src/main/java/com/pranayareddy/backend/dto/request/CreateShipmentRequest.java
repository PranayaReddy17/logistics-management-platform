package com.pranayareddy.backend.dto.request;

import com.pranayareddy.backend.entity.Carrier;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateShipmentRequest {

    @NotBlank
    private String senderName;

    @NotBlank
    private String receiverName;

    @NotBlank
    private String origin;

    @NotBlank
    private String destination;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal weight;

    @NotNull
    private Carrier carrier;

    // Generate getters and setters
}