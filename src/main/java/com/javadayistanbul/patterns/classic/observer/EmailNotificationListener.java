package com.javadayistanbul.patterns.classic.observer;

public class EmailNotificationListener implements OrderEventListener {
    private final String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void onEvent(OrderEvent event) {
        System.out.println("    [Email -> " + email + "] " + event.getEventType() + ": " + event.getDetails());
    }
}
