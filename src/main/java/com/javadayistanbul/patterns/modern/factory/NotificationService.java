package com.javadayistanbul.patterns.modern.factory;

import java.util.Objects;
import java.util.function.BiConsumer;

public enum NotificationService {

    EMAIL((recipient, message) ->
            System.out.println("[Email -> " + recipient + "] " + message)),
    SMS((recipient, message) ->
            System.out.println("[SMS -> " + recipient + "] " + message)),
    PUSH((recipient, message) ->
            System.out.println("[Push -> " + recipient + "] " + message));

    private final BiConsumer<String, String> sender;

    NotificationService(BiConsumer<String, String> sender) {
        this.sender = sender;
    }

    public void send(String recipient, String message) {
        this.sender.accept(
                Objects.requireNonNull(recipient, "recipient cannot be null"),
                Objects.requireNonNull(message, "message cannot be null")
        );
    }
}
