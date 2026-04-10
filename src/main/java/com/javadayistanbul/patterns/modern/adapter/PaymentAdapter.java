package com.javadayistanbul.patterns.modern.adapter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;

public class PaymentAdapter {

    public record LegacyPaymentSystem(String systemName) {
        public boolean processPaymentXML(String xmlPayload, double amount) {
            IO.println("    [Legacy] XML ile odeme isleniyor...");
            IO.println("      Payload: " + xmlPayload);
            IO.println("      Tutar: " + amount + " TL");
            return true;
        }
    }

    public static BiFunction<String, BigDecimal, Boolean> adapt(LegacyPaymentSystem legacy) {
        return (orderId, amount) -> {
            String xmlPayload = "<payment><orderId>" + orderId + "</orderId></payment>";
            double legacyAmount = amount.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
            return legacy.processPaymentXML(xmlPayload, legacyAmount);
        };
    }
}
