package com.pranayareddy.backend.service.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.pranayareddy.backend.entity.Shipment;
import com.pranayareddy.backend.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class ShipmentLabelServiceImpl implements ShipmentLabelService {

    private final ShipmentRepository shipmentRepository;

    public ShipmentLabelServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    @Override
    public byte[] generateLabel(Long shipmentId) {

        Shipment shipment = shipmentRepository.findById(shipmentId)
                .orElseThrow(() ->
                        new RuntimeException("Shipment not found"));

        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            Document document = new Document();

            PdfWriter.getInstance(document, outputStream);

            document.open();

            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font normalFont = new Font(Font.FontFamily.HELVETICA, 12);

            document.add(new Paragraph("Logistics Management Platform", titleFont));
            document.add(new Paragraph(" "));
            document.add(new Paragraph("Tracking Number: " + shipment.getTrackingNumber(), normalFont));
            document.add(new Paragraph("Sender: " + shipment.getSenderName(), normalFont));
            document.add(new Paragraph("Receiver: " + shipment.getReceiverName(), normalFont));
            document.add(new Paragraph("Origin: " + shipment.getOrigin(), normalFont));
            document.add(new Paragraph("Destination: " + shipment.getDestination(), normalFont));
            document.add(new Paragraph("Carrier: " + shipment.getCarrier(), normalFont));
            document.add(new Paragraph("Status: " + shipment.getStatus(), normalFont));
            document.add(new Paragraph("Weight: " + shipment.getWeight() + " kg", normalFont));

            document.close();

            return outputStream.toByteArray();

        } catch (Exception ex) {
            throw new RuntimeException("Failed to generate shipment label", ex);
        }
    }
}