package com.javadayistanbul.patterns.classic.factory;

public class PushNotificationClassicService implements NotificationClassicService {
    @Override
    public void send(String recipient, String message) {
        System.out.println("    [Push -> " + recipient + "] " + message);
    }
}
