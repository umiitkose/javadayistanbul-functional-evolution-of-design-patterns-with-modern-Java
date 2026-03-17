package com.javadayistanbul.patterns.demo;

import com.javadayistanbul.patterns.classic.chainofresponsibility.*;
import com.javadayistanbul.patterns.modern.chainofresponsibility.OrderValidation;

import java.math.BigDecimal;

public class ChainOfResponsibilityDemo {

    public static void run() {
        System.out.println("=".repeat(60));
        System.out.println("  CHAIN OF RESPONSIBILITY PATTERN");
        System.out.println("  Java Feature: Predicate<T> & Composition");
        System.out.println("=".repeat(60));
        System.out.println();

        classicApproach();
        System.out.println();
        modernApproach();
    }

    private static void classicApproach() {
        System.out.println("--- Klasik Yaklasim (Abstract Handler Chain) ---");
        System.out.println("  [5 dosya: 1 abstract handler + 3 concrete + 1 Order]");
        System.out.println();

        var stockHandler = new StockValidationHandler();
        var paymentHandler = new PaymentValidationHandler();
        var addressHandler = new AddressValidationHandler();
        stockHandler.setNext(paymentHandler).setNext(addressHandler);

        var validOrder = new Order("ORD-001", "Ahmet", new BigDecimal("299.99"), "Istanbul, Kadikoy", 5);
        System.out.println("  Gecerli siparis:");
        boolean result = stockHandler.validate(validOrder);
        System.out.println("    Sonuc: " + (result ? "GECERLI" : "GECERSIZ"));

        System.out.println();
        var invalidOrder = new Order("ORD-002", "Mehmet", new BigDecimal("299.99"), "", 5);
        System.out.println("  Gecersiz siparis (adres bos):");
        result = stockHandler.validate(invalidOrder);
        System.out.println("    Sonuc: " + (result ? "GECERLI" : "GECERSIZ"));
    }

    private static void modernApproach() {
        System.out.println("--- Modern Yaklasim (Predicate Chain) ---");
        System.out.println("  [1 dosya: Predicate<Order> + and()/or() kompozisyonu]");
        System.out.println("  Handler sinifi yok! Predicate.and() ile zincirleme!");
        System.out.println();

        var validate = OrderValidation.allValidations();

        var validOrder = new OrderValidation.Order("ORD-001", "Ahmet", new BigDecimal("299.99"), "Istanbul, Kadikoy", 5);
        System.out.println("  Gecerli siparis:");
        boolean result = validate.test(validOrder);
        System.out.println("    Sonuc: " + (result ? "GECERLI" : "GECERSIZ"));

        System.out.println();
        var invalidOrder = new OrderValidation.Order("ORD-002", "Mehmet", new BigDecimal("299.99"), "", 5);
        System.out.println("  Gecersiz siparis (adres bos):");
        result = validate.test(invalidOrder);
        System.out.println("    Sonuc: " + (result ? "GECERLI" : "GECERSIZ"));
    }

    public static void main(String[] args) {
        run();
    }
}
