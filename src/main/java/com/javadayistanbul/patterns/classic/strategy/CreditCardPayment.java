package com.javadayistanbul.patterns.classic.strategy;

import java.math.BigDecimal;

public class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;
    private final String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(BigDecimal amount) {
        String masked = "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
        System.out.println("  Kredi karti ile odeme yapildi: " + amount + " TL");
        System.out.println("    Kart: " + masked + " | Sahibi: " + cardHolderName);
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }
}
