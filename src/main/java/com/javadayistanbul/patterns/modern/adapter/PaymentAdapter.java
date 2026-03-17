package com.javadayistanbul.patterns.modern.adapter;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public class PaymentAdapter {

    public record LegacyPaymentSystem(String systemName) {
        public boolean processPaymentXML(String xmlPayload, double amount) {
            System.out.println("    [Legacy] XML ile odeme isleniyor...");
            System.out.println("      Payload: " + xmlPayload);
            System.out.println("      Tutar: " + amount + " TL");
            return true;
        }
    }

    public static BiFunction<String, BigDecimal, Boolean> adapt(LegacyPaymentSystem legacy) {
        return (orderId, amount) -> {
            String xmlPayload = "<payment><orderId>" + orderId + "</orderId></payment>";
            return legacy.processPaymentXML(xmlPayload, amount.doubleValue());
        };
    }
}
