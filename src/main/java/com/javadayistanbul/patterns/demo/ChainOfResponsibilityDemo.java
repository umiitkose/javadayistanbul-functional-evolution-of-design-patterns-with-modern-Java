package com.javadayistanbul.patterns.demo;

import com.javadayistanbul.patterns.classic.chainofresponsibility.*;
import com.javadayistanbul.patterns.modern.chainofresponsibility.OrderValidation;

import java.math.BigDecimal;

public class ChainOfResponsibilityDemo {

    public static void run() {
        IO.println("=".repeat(60));
        IO.println("  CHAIN OF RESPONSIBILITY PATTERN");
        IO.println("  Java Feature: Predicate<T> & Composition");
        IO.println("=".repeat(60));
        IO.println();

        classicApproach();
        IO.println();
        modernApproach();
    }

    private static void classicApproach() {
        IO.println("--- Klasik Yaklasim (Abstract Handler Chain) ---");
        IO.println("  [5 dosya: 1 abstract handler + 3 concrete + 1 Order]");
        IO.println();

        var stockHandler = new StockValidationHandler();
        var paymentHandler = new PaymentValidationHandler();
        var addressHandler = new AddressValidationHandler();
        stockHandler.setNext(paymentHandler).setNext(addressHandler);

        var validOrder = new Order("ORD-001", "Ahmet", new BigDecimal("299.99"), "Istanbul, Kadikoy", 5);
        IO.println("  Gecerli siparis:");
        boolean result = stockHandler.validate(validOrder);
        IO.println("    Sonuc: " + (result ? "GECERLI" : "GECERSIZ"));

        IO.println();
        var invalidOrder = new Order("ORD-002", "Mehmet", new BigDecimal("299.99"), "", 5);
        IO.println("  Gecersiz siparis (adres bos):");
        result = stockHandler.validate(invalidOrder);
        IO.println("    Sonuc: " + (result ? "GECERLI" : "GECERSIZ"));
    }

    private static void modernApproach() {
        IO.println("--- Modern Yaklasim (Predicate Chain) ---");
        IO.println("  [1 dosya: Predicate<Order> + and()/or() kompozisyonu]");
        IO.println("  Handler sinifi yok! Predicate.and() ile zincirleme!");
        IO.println();

        var validate = OrderValidation.allValidations();

        var validOrder = new OrderValidation.Order("ORD-001", "Ahmet", new BigDecimal("299.99"), "Istanbul, Kadikoy", 5);
        IO.println("  Gecerli siparis:");
        boolean result = validate.test(validOrder);
        IO.println("    Sonuc: " + (result ? "GECERLI" : "GECERSIZ"));

        IO.println();
        var invalidOrder = new OrderValidation.Order("ORD-002", "Mehmet", new BigDecimal("299.99"), "", 5);
        IO.println("  Gecersiz siparis (adres bos):");
        result = validate.test(invalidOrder);
        IO.println("    Sonuc: " + (result ? "GECERLI" : "GECERSIZ"));
    }

    public static void main(String[] args) {
        run();
    }
}
