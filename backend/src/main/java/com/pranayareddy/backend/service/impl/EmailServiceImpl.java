package com.pranayareddy.backend.service.impl;

import com.pranayareddy.backend.service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendShipmentCreatedEmail(
            String to,
            String trackingNumber) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject("Shipment Created");
        message.setText(
                "Your shipment has been created.\n\nTracking Number: "
                        + trackingNumber);

        mailSender.send(message);
    }
}
