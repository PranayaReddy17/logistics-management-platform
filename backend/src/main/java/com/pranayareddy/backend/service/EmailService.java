package com.pranayareddy.backend.service;

public interface EmailService {

    void sendShipmentCreatedEmail(
            String to,
            String trackingNumber);

}