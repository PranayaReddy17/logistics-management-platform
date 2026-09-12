package com.pranayareddy.backend.service.impl;

import com.pranayareddy.backend.dto.request.CreateShipmentRequest;
import com.pranayareddy.backend.dto.request.UpdateShipmentRequest;
import com.pranayareddy.backend.dto.response.ShipmentResponse;
import com.pranayareddy.backend.entity.Carrier;
import com.pranayareddy.backend.entity.Shipment;
import com.pranayareddy.backend.entity.ShipmentStatus;
import com.pranayareddy.backend.repository.ShipmentRepository;
import com.pranayareddy.backend.service.ShipmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public ShipmentResponse createShipment(CreateShipmentRequest request) {

        Shipment shipment = new Shipment();

        shipment.setTrackingNumber(generateTrackingNumber());
        shipment.setSenderName(request.getSenderName());
        shipment.setReceiverName(request.getReceiverName());
        shipment.setOrigin(request.getOrigin());
        shipment.setDestination(request.getDestination());
        shipment.setWeight(request.getWeight());
        shipment.setCarrier(request.getCarrier());

        shipment = shipmentRepository.save(shipment);

        ShipmentResponse response = new ShipmentResponse();

        response.setId(shipment.getId());
        response.setTrackingNumber(shipment.getTrackingNumber());
        response.setSenderName(shipment.getSenderName());
        response.setReceiverName(shipment.getReceiverName());
        response.setOrigin(shipment.getOrigin());
        response.setDestination(shipment.getDestination());
        response.setWeight(shipment.getWeight());
        response.setCarrier(shipment.getCarrier());
        response.setStatus(shipment.getStatus());
        response.setCreatedAt(shipment.getCreatedAt());
        response.setUpdatedAt(shipment.getUpdatedAt());

        return response;
    }

    @Override
    public ShipmentResponse getShipmentById(Long id) {

        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));

        return mapToResponse(shipment);
    }

    @Override
    public ShipmentResponse getShipmentByTrackingNumber(String trackingNumber) {

        Shipment shipment = shipmentRepository
                .findByTrackingNumber(trackingNumber)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));

        return mapToResponse(shipment);
    }

    @Override
    public Page<ShipmentResponse> getAllShipments(
            int page,
            int size,
            String sortBy,
            String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        return shipmentRepository.findAll(pageable)
                .map(this::mapToResponse);
    }

    @Override
    public ShipmentResponse updateShipment(Long id, UpdateShipmentRequest request) {

        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));

        shipment.setSenderName(request.getSenderName());
        shipment.setReceiverName(request.getReceiverName());
        shipment.setOrigin(request.getOrigin());
        shipment.setDestination(request.getDestination());
        shipment.setWeight(request.getWeight());
        shipment.setCarrier(request.getCarrier());

        shipment = shipmentRepository.save(shipment);

        return mapToResponse(shipment);
    }

    @Override
    public void cancelShipment(Long id) {

        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipment not found"));

        shipment.setStatus(ShipmentStatus.CANCELLED);

        shipmentRepository.save(shipment);
    }

    private String generateTrackingNumber() {

        String year = String.valueOf(java.time.Year.now().getValue());

        long count = shipmentRepository.count() + 1;

        return "LMP" + year + String.format("%06d", count);
    }

    private ShipmentResponse mapToResponse(Shipment shipment) {

        ShipmentResponse response = new ShipmentResponse();

        response.setId(shipment.getId());
        response.setTrackingNumber(shipment.getTrackingNumber());
        response.setSenderName(shipment.getSenderName());
        response.setReceiverName(shipment.getReceiverName());
        response.setOrigin(shipment.getOrigin());
        response.setDestination(shipment.getDestination());
        response.setWeight(shipment.getWeight());
        response.setCarrier(shipment.getCarrier());
        response.setStatus(shipment.getStatus());
        response.setCreatedAt(shipment.getCreatedAt());
        response.setUpdatedAt(shipment.getUpdatedAt());

        return response;
    }

    @Override
    public Page<ShipmentResponse> searchShipments(
            ShipmentStatus status,
            Carrier carrier,
            String origin,
            String destination,
            int page,
            int size) {

        Pageable pageable = PageRequest.of(page, size);

        if (status != null) {
            return shipmentRepository.findByStatus(status, pageable)
                    .map(this::mapToResponse);
        }

        if (carrier != null) {
            return shipmentRepository.findByCarrier(carrier, pageable)
                    .map(this::mapToResponse);
        }

        if (origin != null && !origin.isBlank()) {
            return shipmentRepository
                    .findByOriginContainingIgnoreCase(origin, pageable)
                    .map(this::mapToResponse);
        }

        if (destination != null && !destination.isBlank()) {
            return shipmentRepository
                    .findByDestinationContainingIgnoreCase(destination, pageable)
                    .map(this::mapToResponse);
        }

        return shipmentRepository.findAll(pageable)
                .map(this::mapToResponse);
    }
}