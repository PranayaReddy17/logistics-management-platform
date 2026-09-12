package com.pranayareddy.backend.repository;

import com.pranayareddy.backend.entity.Shipment;
import com.pranayareddy.backend.entity.ShipmentTracking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShipmentTrackingRepository
        extends JpaRepository<ShipmentTracking, Long> {

    List<ShipmentTracking> findByShipmentOrderByEventTimeAsc(Shipment shipment);
}