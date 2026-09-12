package com.pranayareddy.backend.controller;

import com.pranayareddy.backend.dto.request.CreateShipmentRequest;
import com.pranayareddy.backend.dto.request.UpdateShipmentRequest;
import com.pranayareddy.backend.dto.response.ShipmentResponse;
import com.pranayareddy.backend.entity.Carrier;
import com.pranayareddy.backend.entity.ShipmentStatus;
import com.pranayareddy.backend.service.ShipmentService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    public ShipmentController(ShipmentService shipmentService) {
        this.shipmentService = shipmentService;
    }

    @PostMapping
    public ResponseEntity<ShipmentResponse> createShipment(
            @Valid @RequestBody CreateShipmentRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(shipmentService.createShipment(request));
    }

    @GetMapping
    public ResponseEntity<Page<ShipmentResponse>> getAllShipments(

            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        return ResponseEntity.ok(
                shipmentService.getAllShipments(
                        page,
                        size,
                        sortBy,
                        direction));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShipmentResponse> getShipmentById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                shipmentService.getShipmentById(id));
    }
    @GetMapping("/tracking/{trackingNumber}")
    public ResponseEntity<ShipmentResponse> getShipmentByTrackingNumber(
            @PathVariable String trackingNumber) {

        return ResponseEntity.ok(
                shipmentService.getShipmentByTrackingNumber(trackingNumber));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShipmentResponse> updateShipment(
            @PathVariable Long id,
            @Valid @RequestBody UpdateShipmentRequest request) {

        return ResponseEntity.ok(
                shipmentService.updateShipment(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelShipment(@PathVariable Long id) {

        shipmentService.cancelShipment(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Page<ShipmentResponse>> searchShipments(

            @RequestParam(required = false) ShipmentStatus status,
            @RequestParam(required = false) Carrier carrier,
            @RequestParam(required = false) String origin,
            @RequestParam(required = false) String destination,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return ResponseEntity.ok(
                shipmentService.searchShipments(
                        status,
                        carrier,
                        origin,
                        destination,
                        page,
                        size));
    }
}