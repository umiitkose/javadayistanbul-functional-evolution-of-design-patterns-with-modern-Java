package com.javadayistanbul.patterns.classic.adapter;

public class LegacyPaymentSystem {
    public boolean processPaymentXML(String xmlPayload, double amount) {
        IO.println("    [Legacy] XML ile odeme isleniyor...");
        IO.println("      Payload: " + xmlPayload);
        IO.println("      Tutar: " + amount + " TL");
        return true;
    }
}
