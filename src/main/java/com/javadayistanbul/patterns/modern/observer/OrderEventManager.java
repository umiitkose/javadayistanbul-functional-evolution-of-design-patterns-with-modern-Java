package com.javadayistanbul.patterns.modern.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class OrderEventManager {

    public record OrderEvent(String orderId, String eventType, String details) {}

    private final Map<String, List<Consumer<OrderEvent>>> listeners = new HashMap<>();

    public void subscribe(String eventType, Consumer<OrderEvent> listener) {
        listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);
    }

    public void unsubscribe(String eventType, Consumer<OrderEvent> listener) {
        listeners.getOrDefault(eventType, List.of()).remove(listener);
    }

    public void notify(String eventType, OrderEvent event) {
        listeners.getOrDefault(eventType, List.of()).forEach(l -> l.accept(event));
    }
}
