package com.lawyersofafrica.lawyersofafrica.notification.service;

public interface NotificationService {
    void sendSimpleMessage(String to, String subject, String text);
}
