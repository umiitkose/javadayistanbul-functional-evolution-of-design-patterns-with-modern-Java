package com.javadayistanbul.patterns.classic.observer;

public class EmailNotificationListener implements OrderEventListener {
    private final String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void onEvent(OrderEvent event) {
        IO.println("    [Email -> " + email + "] " + event.getEventType() + ": " + event.getDetails());
    }
}
