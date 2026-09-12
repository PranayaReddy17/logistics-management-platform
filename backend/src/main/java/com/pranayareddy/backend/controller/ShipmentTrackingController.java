package com.pranayareddy.backend.controller;

import com.pranayareddy.backend.dto.request.AddTrackingEventRequest;
import com.pranayareddy.backend.dto.response.ShipmentTrackingResponse;
import com.pranayareddy.backend.service.ShipmentTrackingService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shipments")
public class ShipmentTrackingController {

    private final ShipmentTrackingService shipmentTrackingService;

    public ShipmentTrackingController(
            ShipmentTrackingService shipmentTrackingService) {

        this.shipmentTrackingService = shipmentTrackingService;
    }

    @PostMapping("/{shipmentId}/tracking")
    public ResponseEntity<ShipmentTrackingResponse> addTrackingEvent(
            @PathVariable Long shipmentId,
            @Valid @RequestBody AddTrackingEventRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(shipmentTrackingService.addTrackingEvent(
                        shipmentId, request));
    }

    @GetMapping("/{shipmentId}/tracking")
    public ResponseEntity<List<ShipmentTrackingResponse>> getTrackingHistory(
            @PathVariable Long shipmentId) {

        return ResponseEntity.ok(
                shipmentTrackingService.getTrackingHistory(shipmentId));
    }
}