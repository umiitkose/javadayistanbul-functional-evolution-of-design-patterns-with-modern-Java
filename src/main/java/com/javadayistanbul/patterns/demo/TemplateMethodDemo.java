package com.javadayistanbul.patterns.demo;

import com.javadayistanbul.patterns.classic.templatemethod.StandardOrderProcessor;
import com.javadayistanbul.patterns.classic.templatemethod.PremiumOrderProcessor;

import java.math.BigDecimal;
import java.util.List;

public class TemplateMethodDemo {

    public static void run() {
        System.out.println("=".repeat(60));
        System.out.println("  TEMPLATE METHOD PATTERN");
        System.out.println("  Java Feature: Higher-Order Functions & Composition");
        System.out.println("=".repeat(60));
        System.out.println();

        classicApproach();
        System.out.println();
        modernApproach();
    }

    private static void classicApproach() {
        System.out.println("--- Klasik Yaklasim (Abstract Class + Inheritance) ---");
        System.out.println("  [4 dosya: 1 abstract + 2 concrete + 1 Order]");
        System.out.println("  Her yeni islem tipi icin yeni bir sinif gerekir!");
        System.out.println();

        var order = new com.javadayistanbul.patterns.classic.templatemethod.Order(
                "ORD-001", "Ahmet Yilmaz",
                List.of(
                        new com.javadayistanbul.patterns.classic.templatemethod.Order.Item(
                                "Java in Action", new BigDecimal("75.00"), 1),
                        new com.javadayistanbul.patterns.classic.templatemethod.Order.Item(
                                "Clean Code", new BigDecimal("65.00"), 1)
                )
        );

        System.out.println("  >> Standart Islem:");
        new StandardOrderProcessor().process(order);
        System.out.println();

        System.out.println("  >> Premium Islem:");
        new PremiumOrderProcessor().process(order);
    }

    private static void modernApproach() {
        System.out.println("--- Modern Yaklasim (Functional Composition) ---");
        System.out.println("  [2 dosya: 1 record processor + 1 Order]");
        System.out.println("  Abstract class yok! Inheritance yok!");
        System.out.println("  Davranislar fonksiyon olarak enjekte ediliyor!");
        System.out.println();

        var order = new com.javadayistanbul.patterns.modern.templatemethod.Order(
                "ORD-001", "Ahmet Yilmaz",
                List.of(
                        new com.javadayistanbul.patterns.modern.templatemethod.Order.Item(
                                "Java in Action", new BigDecimal("75.00"), 1),
                        new com.javadayistanbul.patterns.modern.templatemethod.Order.Item(
                                "Clean Code", new BigDecimal("65.00"), 1)
                )
        );

        System.out.println("  >> Standart Islem:");
        com.javadayistanbul.patterns.modern.templatemethod.OrderProcessor.standard().process(order);
        System.out.println();

        System.out.println("  >> Premium Islem:");
        com.javadayistanbul.patterns.modern.templatemethod.OrderProcessor.premium().process(order);
    }

    public static void main(String[] args) {
        run();
    }
}
