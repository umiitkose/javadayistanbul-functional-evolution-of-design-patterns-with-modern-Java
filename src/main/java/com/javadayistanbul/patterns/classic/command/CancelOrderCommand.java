package com.javadayistanbul.patterns.classic.command;

public class CancelOrderCommand implements OrderCommand {
    private final String orderId;
    private final String reason;

    public CancelOrderCommand(String orderId, String reason) {
        this.orderId = orderId;
        this.reason = reason;
    }

    @Override
    public void execute() {
        System.out.println("    Siparis iptal edildi: #" + orderId + " | Sebep: " + reason);
    }
}
