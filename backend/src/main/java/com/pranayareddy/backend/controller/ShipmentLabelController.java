package com.pranayareddy.backend.controller;

import com.pranayareddy.backend.service.pdf.ShipmentLabelService;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shipments")
public class ShipmentLabelController {

    private final ShipmentLabelService shipmentLabelService;

    public ShipmentLabelController(ShipmentLabelService shipmentLabelService) {
        this.shipmentLabelService = shipmentLabelService;
    }

    @GetMapping("/{id}/label")
    public ResponseEntity<byte[]> downloadLabel(@PathVariable Long id) {

        byte[] pdf = shipmentLabelService.generateLabel(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        ContentDisposition.attachment()
                                .filename("shipment-label.pdf")
                                .build()
                                .toString())
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }
}