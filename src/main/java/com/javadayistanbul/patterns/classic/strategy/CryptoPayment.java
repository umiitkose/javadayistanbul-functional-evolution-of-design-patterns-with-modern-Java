package com.javadayistanbul.patterns.classic.strategy;

import java.math.BigDecimal;

public class CryptoPayment implements PaymentStrategy {
    private final String walletAddress;
    private final String cryptoType;

    public CryptoPayment(String walletAddress, String cryptoType) {
        this.walletAddress = walletAddress;
        this.cryptoType = cryptoType;
    }

    @Override
    public void pay(BigDecimal amount) {
        System.out.println("  Kripto para ile odeme yapildi: " + amount + " TL");
        System.out.println("    Cuzdan: " + walletAddress + " | Tur: " + cryptoType);
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public String getCryptoType() {
        return cryptoType;
    }
}
