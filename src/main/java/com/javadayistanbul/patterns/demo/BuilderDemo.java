package com.javadayistanbul.patterns.demo;

import com.javadayistanbul.patterns.classic.builder.OrderClassic;

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
        System.out.println("  [1 dosya: POJO + nested static Builder]");
        System.out.println("  Zorunlu alanlar: id, customerId, items");
        System.out.println("  ~90 satir boilerplate kod!");
        System.out.println();

        var order = new OrderClassic.Builder()
                .id("ORD-001")
                .customerId("CUST-42")
                .addItem("Java in Action")
                .addItem("Design Patterns")
                .build();

        order.setShippingAddress("Istanbul, Kadikoy");
        order.setTotalAmount(new BigDecimal("149.90"));

        System.out.println("  Siparis: " + order);
    }

    private static void modernApproach() {
        System.out.println("--- Modern Yaklasim (Record + Immutable update) ---");
        System.out.println("  [1 dosya: record + compact constructor]");
        System.out.println("  Zorunlu alanlar: id, customerId, items");
        System.out.println("  toString/equals/hashCode otomatik!");
        System.out.println("  Immutable by default!");
        System.out.println();

        var order = new com.javadayistanbul.patterns.modern.builder.Order(
                "ORD-001",
                "CUST-42",
                null,
                List.of("Java in Action", "Design Patterns"),
                null,
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
