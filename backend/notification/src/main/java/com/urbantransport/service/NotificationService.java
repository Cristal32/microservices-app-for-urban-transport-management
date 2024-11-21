package com.urbantransport.service;

import com.urbantransport.Notification;
import com.urbantransport.NotificationRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final EmailService emailService;  // Add EmailService for email functionality

    @Autowired
    public NotificationService(NotificationRepository notificationRepository, EmailService emailService) {
        this.notificationRepository = notificationRepository;
        this.emailService = emailService;
    }

    @KafkaListener(topics = "urbantransport", groupId = "groupId1")
    public void listen(String message) {
        // Save to database
        Notification notification = new Notification();
        notification.setMessage(message);
        notification.setTimestamp(LocalDateTime.now());
        notification.setRecipientEmail("fatibraikat@gmail.com");
        notificationRepository.save(notification);

        // Send email notification
        emailService.sendEmail(notification.getRecipientEmail(), "New Notification", message);
    }
}
