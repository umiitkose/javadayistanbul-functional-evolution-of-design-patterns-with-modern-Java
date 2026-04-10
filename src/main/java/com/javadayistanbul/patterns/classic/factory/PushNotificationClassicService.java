package com.javadayistanbul.patterns.classic.factory;

public class PushNotificationClassicService implements NotificationClassicService {
    @Override
    public void send(String recipient, String message) {
        IO.println("    [Push -> " + recipient + "] " + message);
    }
}
