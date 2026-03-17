package com.javadayistanbul.patterns.classic.observer;

public class SmsNotificationListener implements OrderEventListener {
    private final String phoneNumber;

    public SmsNotificationListener(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void onEvent(OrderEvent event) {
        System.out.println("    [SMS -> " + phoneNumber + "] " + event.getEventType() + ": " + event.getDetails());
    }
}
