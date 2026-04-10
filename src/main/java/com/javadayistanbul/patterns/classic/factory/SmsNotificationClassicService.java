package com.javadayistanbul.patterns.classic.factory;

public class SmsNotificationClassicService implements NotificationClassicService {
    @Override
    public void send(String recipient, String message) {
        IO.println("    [SMS -> " + recipient + "] " + message);
    }
}
