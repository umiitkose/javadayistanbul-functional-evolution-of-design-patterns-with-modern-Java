package com.javadayistanbul.patterns.demo;

import com.javadayistanbul.patterns.classic.strategy.*;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class StrategyDemo {

    public static void run() {
        IO.println("=".repeat(60));
        IO.println("  STRATEGY PATTERN");
        IO.println("  Java Feature: Lambda Expressions & Functional Interface");
        IO.println("=".repeat(60));
        IO.println();

        var amount = new BigDecimal("299.99");

        classicApproach(amount);
        IO.println();
        modernApproach(amount);
    }

    private static void classicApproach(BigDecimal amount) {
        IO.println("--- Klasik Yaklasim (OOP) ---");
        IO.println("  [5 dosya: 1 interface + 3 concrete class + 1 service]");
        IO.println();

        var service = new PaymentService(
                new CreditCardPayment("4532015112830366", "Ahmet Yilmaz")
        );
        service.processPayment(amount);

        IO.println();
        service.setStrategy(new BankTransferPayment("TR330006100519786457841326", "Garanti"));
        service.processPayment(amount);

        IO.println();
        service.setStrategy(new CryptoPayment("0x742d35Cc6634C0532925a3b8", "ETH"));
        service.processPayment(amount);
    }

    private static void modernApproach(BigDecimal amount) {
        IO.println("--- Modern Yaklasim (Functional) ---");
        IO.println("  [Tek dosya: Consumer<BigDecimal> + lambda]");
        IO.println("  Interface yok! Concrete class yok!");
        IO.println();

        Consumer<BigDecimal> creditCard = com.javadayistanbul.patterns.modern.strategy.PaymentService
                .creditCard("4532015112830366", "Ahmet Yilmaz");
        creditCard.accept(amount);

        IO.println();
        Consumer<BigDecimal> bankTransfer = com.javadayistanbul.patterns.modern.strategy.PaymentService
                .bankTransfer("TR330006100519786457841326", "Garanti");
        bankTransfer.accept(amount);

        IO.println();
        Consumer<BigDecimal> crypto = com.javadayistanbul.patterns.modern.strategy.PaymentService
                .crypto("0x742d35Cc6634C0532925a3b8", "ETH");
        crypto.accept(amount);
    }

    public static void main(String[] args) {
        run();
    }
}
