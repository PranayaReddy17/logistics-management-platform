package com.pranayareddy.backend.service.pdf;

public interface ShipmentLabelService {

    byte[] generateLabel(Long shipmentId);

}