package com.pranayareddy.backend.service;

import com.pranayareddy.backend.dto.request.AddTrackingEventRequest;
import com.pranayareddy.backend.dto.response.ShipmentTrackingResponse;

import java.util.List;


public interface ShipmentTrackingService {

    ShipmentTrackingResponse addTrackingEvent(
            Long shipmentId,
            AddTrackingEventRequest request);

    List<ShipmentTrackingResponse> getTrackingHistory(
            Long shipmentId);
}