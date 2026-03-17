package com.javadayistanbul.patterns.demo;


import com.javadayistanbul.patterns.classic.builder.OrderClassicBuilder;

import java.math.BigDecimal;
import java.util.List;

public class BuilderDemo {

    public static void run() {
        System.out.println("=".repeat(60));
        System.out.println("  BUILDER PATTERN");
        System.out.println("  Java Feature: Records & Compact Constructors");
        System.out.println("=".repeat(60));
        System.out.println();

        classicApproach();
        System.out.println();
        modernApproach();
    }

    private static void classicApproach() {
        System.out.println("--- Klasik Yaklasim (POJO + Builder) ---");
        System.out.println("  [2 dosya: 1 POJO (getter/setter/equals/hashCode/toString) + 1 Builder]");
        System.out.println("  ~90 satir boilerplate kod!");
        System.out.println();

        var order = new OrderClassicBuilder()
                .id("ORD-001")
                .customerId("CUST-42")
                .customerName("Ahmet Yilmaz")
                .addItem("Java in Action")
                .addItem("Design Patterns")
                .totalAmount(new BigDecimal("149.90"))
                .shippingAddress("Istanbul, Kadikoy")
                .build();

        System.out.println("  Siparis: " + order);
    }

    private static void modernApproach() {
        System.out.println("--- Modern Yaklasim (Record + Nested Builder) ---");
        System.out.println("  [1 dosya: record + compact constructor + nested static Builder]");
        System.out.println("  toString/equals/hashCode otomatik!");
        System.out.println("  Immutable by default!");
        System.out.println();

        var order = new com.javadayistanbul.patterns.modern.builder.Order(
                "ORD-001",
                "CUST-42",
                "Ahmet Yilmaz",
                List.of("Java in Action", "Design Patterns"),
                new BigDecimal("149.90"),
                null,
                null
        );

        System.out.println("  Siparis: " + order);

        var withAddress = order.withShippingAddress("Istanbul, Kadikoy");
        System.out.println("  Adresli: " + withAddress);

        var withNewTotal = withAddress.withTotalAmount(new BigDecimal("129.90"));
        System.out.println("  Indirimli: " + withNewTotal);
    }

    public static void main(String[] args) {
        run();
    }
}
