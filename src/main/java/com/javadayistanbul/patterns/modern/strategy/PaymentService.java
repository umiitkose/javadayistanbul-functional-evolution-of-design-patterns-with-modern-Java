package com.javadayistanbul.patterns.modern.strategy;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class PaymentService {

    public static Consumer<BigDecimal> creditCard(String cardNumber, String cardHolderName) {
        return amount -> {
            String masked = "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
            IO.println("  Kredi karti ile odeme yapildi: " + amount + " TL");
            IO.println("    Kart: " + masked + " | Sahibi: " + cardHolderName);
        };
    }

    public static Consumer<BigDecimal> bankTransfer(String iban, String bankName) {
        return amount -> {
            IO.println("  Banka havalesi ile odeme yapildi: " + amount + " TL");
            IO.println("    IBAN: " + iban + " | Banka: " + bankName);
        };
    }

    public static Consumer<BigDecimal> crypto(String walletAddress, String cryptoType) {
        return amount -> {
            IO.println("  Kripto para ile odeme yapildi: " + amount + " TL");
            IO.println("    Cuzdan: " + walletAddress + " | Tur: " + cryptoType);
        };
    }

    public static void processPayment(Consumer<BigDecimal> strategy, BigDecimal amount) {
        strategy.accept(amount);
    }
}
