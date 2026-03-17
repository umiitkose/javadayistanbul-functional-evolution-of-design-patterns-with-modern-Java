package com.javadayistanbul.patterns.classic.observer;

public class OrderEvent {
    private final String orderId;
    private final String eventType;
    private final String details;

    public OrderEvent(String orderId, String eventType, String details) {
        this.orderId = orderId;
        this.eventType = eventType;
        this.details = details;
    }

    public String getOrderId() { return orderId; }
    public String getEventType() { return eventType; }
    public String getDetails() { return details; }

    @Override
    public String toString() {
        return "OrderEvent{orderId='" + orderId + "', type='" + eventType + "', details='" + details + "'}";
    }
}
