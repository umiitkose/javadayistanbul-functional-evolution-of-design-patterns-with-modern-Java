package com.javadayistanbul.patterns.classic.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderEventManager {
    private final Map<String, List<OrderEventListener>> listeners = new HashMap<>();

    public void subscribe(String eventType, OrderEventListener listener) {
        listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);
    }

    public void unsubscribe(String eventType, OrderEventListener listener) {
        listeners.getOrDefault(eventType, List.of()).remove(listener);
    }

    public void notify(String eventType, OrderEvent event) {
        listeners.getOrDefault(eventType, List.of()).forEach(l -> l.onEvent(event));
    }
}
