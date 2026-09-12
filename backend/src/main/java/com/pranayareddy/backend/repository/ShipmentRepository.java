package com.pranayareddy.backend.repository;

import com.pranayareddy.backend.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pranayareddy.backend.entity.Carrier;
import com.pranayareddy.backend.entity.ShipmentStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    Optional<Shipment> findByTrackingNumber(String trackingNumber);

    boolean existsByTrackingNumber(String trackingNumber);

    Page<Shipment> findByStatus(ShipmentStatus status, Pageable pageable);

    Page<Shipment> findByCarrier(Carrier carrier, Pageable pageable);

    Page<Shipment> findByOriginContainingIgnoreCase(String origin, Pageable pageable);

    Page<Shipment> findByDestinationContainingIgnoreCase(String destination, Pageable pageable);
}