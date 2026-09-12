package com.pranayareddy.backend.service;

import com.pranayareddy.backend.dto.request.CreateShipmentRequest;
import com.pranayareddy.backend.dto.request.UpdateShipmentRequest;
import com.pranayareddy.backend.dto.response.ShipmentResponse;
import com.pranayareddy.backend.entity.Carrier;
import com.pranayareddy.backend.entity.ShipmentStatus;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ShipmentService {

    ShipmentResponse createShipment(CreateShipmentRequest request);

    ShipmentResponse getShipmentById(Long id);

    ShipmentResponse getShipmentByTrackingNumber(String trackingNumber);

    Page<ShipmentResponse> getAllShipments(
            int page,
            int size,
            String sortBy,
            String direction);

    ShipmentResponse updateShipment(Long id, UpdateShipmentRequest request);

    void cancelShipment(Long id);

    Page<ShipmentResponse> searchShipments(
            ShipmentStatus status,
            Carrier carrier,
            String origin,
            String destination,
            int page,
            int size);
}