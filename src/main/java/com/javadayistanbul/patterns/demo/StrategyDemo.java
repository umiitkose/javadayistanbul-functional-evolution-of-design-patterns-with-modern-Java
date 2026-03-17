package com.javadayistanbul.patterns.demo;

import com.javadayistanbul.patterns.classic.strategy.*;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class StrategyDemo {

    public static void run() {
        System.out.println("=".repeat(60));
        System.out.println("  STRATEGY PATTERN");
        System.out.println("  Java Feature: Lambda Expressions & Functional Interface");
        System.out.println("=".repeat(60));
        System.out.println();

        var amount = new BigDecimal("299.99");

        classicApproach(amount);
        System.out.println();
        modernApproach(amount);
    }

    private static void classicApproach(BigDecimal amount) {
        System.out.println("--- Klasik Yaklasim (OOP) ---");
        System.out.println("  [5 dosya: 1 interface + 3 concrete class + 1 service]");
        System.out.println();

        var service = new PaymentService(
                new CreditCardPayment("4532015112830366", "Ahmet Yilmaz")
        );
        service.processPayment(amount);

        System.out.println();
        service.setStrategy(new BankTransferPayment("TR330006100519786457841326", "Garanti"));
        service.processPayment(amount);

        System.out.println();
        service.setStrategy(new CryptoPayment("0x742d35Cc6634C0532925a3b8", "ETH"));
        service.processPayment(amount);
    }

    private static void modernApproach(BigDecimal amount) {
        System.out.println("--- Modern Yaklasim (Functional) ---");
        System.out.println("  [Tek dosya: Consumer<BigDecimal> + lambda]");
        System.out.println("  Interface yok! Concrete class yok!");
        System.out.println();

        Consumer<BigDecimal> creditCard = com.javadayistanbul.patterns.modern.strategy.PaymentService
                .creditCard("4532015112830366", "Ahmet Yilmaz");
        creditCard.accept(amount);

        System.out.println();
        Consumer<BigDecimal> bankTransfer = com.javadayistanbul.patterns.modern.strategy.PaymentService
                .bankTransfer("TR330006100519786457841326", "Garanti");
        bankTransfer.accept(amount);

        System.out.println();
        Consumer<BigDecimal> crypto = com.javadayistanbul.patterns.modern.strategy.PaymentService
                .crypto("0x742d35Cc6634C0532925a3b8", "ETH");
        crypto.accept(amount);
    }

    public static void main(String[] args) {
        run();
    }
}
