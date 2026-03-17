package com.javadayistanbul.patterns.classic.strategy;

import java.math.BigDecimal;

public class BankTransferPayment implements PaymentStrategy {
    private final String iban;
    private final String bankName;

    public BankTransferPayment(String iban, String bankName) {
        this.iban = iban;
        this.bankName = bankName;
    }

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("  Banka havalesi ile odeme yapildi: " + amount + " TL");
        System.out.println("    IBAN: " + iban + " | Banka: " + bankName);
    }

    public String getIban() {
        return iban;
    }

    public String getBankName() {
        return bankName;
    }
}
