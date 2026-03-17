package com.javadayistanbul.patterns.classic.factory;

public class EmailNotificationClassicService implements NotificationClassicService {
    @Override
    public void send(String recipient, String message) {
        System.out.println("    [Email -> " + recipient + "] " + message);
    }
}
