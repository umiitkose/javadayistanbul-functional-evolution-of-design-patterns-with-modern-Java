package com.javadayistanbul.patterns.classic.command;

import java.math.BigDecimal;

public class RefundCommand implements OrderCommand {
    private final String orderId;
    private final BigDecimal amount;

    public RefundCommand(String orderId, BigDecimal amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    @Override
    public void execute() {
        System.out.println("    Iade islemi yapildi: #" + orderId + " | Tutar: " + amount + " TL");
    }
}
