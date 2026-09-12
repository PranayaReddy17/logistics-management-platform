package com.pranayareddy.backend.service.impl;

import com.pranayareddy.backend.dto.request.AddTrackingEventRequest;
import com.pranayareddy.backend.dto.response.ShipmentTrackingResponse;
import com.pranayareddy.backend.entity.Shipment;
import com.pranayareddy.backend.entity.ShipmentTracking;
import com.pranayareddy.backend.repository.ShipmentRepository;
import com.pranayareddy.backend.repository.ShipmentTrackingRepository;
import com.pranayareddy.backend.service.ShipmentTrackingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentTrackingServiceImpl
        implements ShipmentTrackingService {

    private final ShipmentRepository shipmentRepository;
    private final ShipmentTrackingRepository trackingRepository;

    public ShipmentTrackingServiceImpl(
            ShipmentRepository shipmentRepository,
            ShipmentTrackingRepository trackingRepository) {

        this.shipmentRepository = shipmentRepository;
        this.trackingRepository = trackingRepository;
    }

    @Override
    public ShipmentTrackingResponse addTrackingEvent(
            Long shipmentId,
            AddTrackingEventRequest request) {

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() ->
                        new RuntimeException("Shipment not found"));

        ShipmentTracking tracking = new ShipmentTracking();

        tracking.setShipment(shipment);
        tracking.setStatus(request.getStatus());
        tracking.setLocation(request.getLocation());
        tracking.setDescription(request.getDescription());

        tracking = trackingRepository.save(tracking);

        shipment.setStatus(request.getStatus());
        shipmentRepository.save(shipment);

        return mapToResponse(tracking);
    }

    @Override
    public List<ShipmentTrackingResponse> getTrackingHistory(
            Long shipmentId) {

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() ->
                        new RuntimeException("Shipment not found"));

        return trackingRepository
                .findByShipmentOrderByEventTimeAsc(shipment)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private ShipmentTrackingResponse mapToResponse(
            ShipmentTracking tracking) {

        ShipmentTrackingResponse response =
                new ShipmentTrackingResponse();

        response.setStatus(tracking.getStatus());
        response.setLocation(tracking.getLocation());
        response.setDescription(tracking.getDescription());
        response.setEventTime(tracking.getEventTime());

        return response;
    }
}