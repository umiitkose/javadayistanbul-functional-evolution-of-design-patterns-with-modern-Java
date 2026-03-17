package com.javadayistanbul.patterns.classic.adapter;

import java.math.BigDecimal;

public class LegacyPaymentSystem {
    public boolean processPaymentXML(String xmlPayload, double amount) {
        System.out.println("    [Legacy] XML ile odeme isleniyor...");
        System.out.println("      Payload: " + xmlPayload);
        System.out.println("      Tutar: " + amount + " TL");
        return true;
    }
}
