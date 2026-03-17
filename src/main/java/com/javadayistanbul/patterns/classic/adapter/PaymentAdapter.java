package com.javadayistanbul.patterns.classic.adapter;

import java.math.BigDecimal;

public class PaymentAdapter implements ModernPaymentGateway {
    private final LegacyPaymentSystem legacySystem;

    public PaymentAdapter(LegacyPaymentSystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public boolean pay(String orderId, BigDecimal amount) {
        String xmlPayload = "<payment><orderId>" + orderId + "</orderId></payment>";
        return legacySystem.processPaymentXML(xmlPayload, amount.doubleValue());
    }
}
